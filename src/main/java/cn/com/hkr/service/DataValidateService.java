package cn.com.hkr.service;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.exception.ParamException;
import cn.com.hkr.mapper.DataValidateMapper;
import cn.com.hkr.utils.StaticUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author jason
 * @date 2022/4/13-17:43
 */
@Service
public class DataValidateService extends  BaseService{

    @Autowired
    private DataValidateMapper dataValidateMapper;

    /**
     * 开始启动年龄，性别，出生日期校验器
     */
    public List<Map> startValidateAll(){
        List<Map> allUser = dataValidateMapper.findAllUser();
        List<Map> illgeUsers = new ArrayList<>();
        for (Map user: allUser){
            String uid = (String) user.get("uid");
            String idcard = (String) user.get("idcard");
            String sex = (String) user.get("sex");
            int age = (int) user.get("age");
            String birthday = ymd.format(user.get("birthday"));

            // 校验身份是否合法
            if (StaticUtils.verifyIDCard(idcard)){
                Map<String, String> birAgeSex = StaticUtils.getBirAgeSex(idcard);
                birAgeSex.put("sexCode",birAgeSex.get("sexCode").equals("F")?"女":"男");
                String mapSex = birAgeSex.get("sexCode");
                if (null != sex && !mapSex.equals(sex)){
                    dataValidateMapper.updateUserSex(uid,mapSex);
                }

                Integer mapAge = Integer.parseInt(birAgeSex.get("age"));
                if (mapAge != age){
                    dataValidateMapper.updateAge(uid,mapAge);
                }


                String mapBirth = birAgeSex.get("birthday");
                if (null != birthday && !mapBirth.equals(birthday)){
                    dataValidateMapper.updateBirthday(uid,mapBirth);
                }


            }else{
                //将不合法人员的信息查询出来
                Map iguser = dataValidateMapper.findByIdcard(idcard);
                illgeUsers.add(iguser);

            }
        }

        return illgeUsers;



    }

    /**
     * 导入已入场人员名单
     * @param fileName
     */
    public void importFinishData(String fileName) {


        try {
            //先删除所有数据
            dataValidateMapper.deleteAlldata();

            //使用poi读取并写入到数据库
            File file  = new File(fileName);

            XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(file));

            XSSFSheet sheet = wk.getSheetAt(1);
            int title_index  = 0;
            int username = 1;
            int company  = 4;
            int salary = 5;
            int reportTime = 6;
            int title =  7;
            int status = 8;
            int ps = 9;

            Map data = null;
            for(Row row  : sheet){
                int rownum = row.getRowNum();
                String cellvalue = row.getCell(1).getStringCellValue();
                if (rownum == 0 || null == cellvalue ||  cellvalue.equals("")){
                    continue;
                }
                title_index += 1;
                data = new HashMap();
                //准备数据:username,company,salary,reportTime,title,status,ps
                data.put("username",row.getCell(username).getStringCellValue());
                data.put("company",row.getCell(company).getStringCellValue());
                data.put("salary",row.getCell(salary).getStringCellValue().replace("k",""));
                Date date = row.getCell(reportTime).getDateCellValue();
                data.put("reportTime",date == null?new Date():ymd.format(date));
                data.put("title",row.getCell(title).getStringCellValue());
                data.put("status",row.getCell(status).getStringCellValue().equals("未办理")?0:1);
                data.put("ps",row.getCell(ps).getStringCellValue());

//                System.out.println(data);
                dataValidateMapper.addFinishUser(data);

            }

        } catch (Exception e) {
            throw new ParamException("读取或者写入异常" + e.getMessage());
        }


    }




    /**
     * 查询所有已经入场的人员名单
     * @param tea
     * @return
     */
    public List<Map> findAllFinish(Teacher tea) {

        return dataValidateMapper.findAllFinishUser();

    }




    /**
     * 判断数据是否为数字
     * @param object
     * @return
     */
    private  boolean isDigit(String object){

        try {
            Integer.parseInt(object);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }
}
