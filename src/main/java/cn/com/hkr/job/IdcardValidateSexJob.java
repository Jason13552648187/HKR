package cn.com.hkr.job;

import cn.com.hkr.mapper.DataValidateMapper;
import cn.com.hkr.utils.StaticUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2022/4/8-17:32
 */
@Component
public class IdcardValidateSexJob implements Job {
    @Autowired
    private DataValidateMapper dataValidateMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        validateAllSex();
    }


    /**
     * 校验数据里所有人的性别的任务
     */
    public void validateAllSex(){
        List<Map> allUser = dataValidateMapper.findAllUser();
        for (Map user: allUser){
            String uid = (String) user.get("uid");
            String idcard = (String) user.get("idcard");
            String sex = (String) user.get("sex");

            // 校验身份是否合法
            if (StaticUtils.verifyIDCard(idcard)){
                Map<String, String> birAgeSex = StaticUtils.getBirAgeSex(idcard);
                birAgeSex.put("sexCode",birAgeSex.get("sexCode").equals("F")?"女":"男");
                String mapSex = birAgeSex.get("sexCode");
                if (null != sex && !mapSex.equals(sex)){
                    dataValidateMapper.updateUserSex(uid,mapSex);
                }

            }else{
                //将不合法人员的信息查询出来
                Map iguser = dataValidateMapper.findByIdcard(idcard);
            }
        }
    }
}
