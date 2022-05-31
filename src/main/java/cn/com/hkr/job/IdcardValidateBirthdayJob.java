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

import static cn.com.hkr.service.BaseService.ymd;

/**
 * @author jason
 * @date 2022/4/8-17:28
 */
@Component
public class IdcardValidateBirthdayJob implements Job {

    @Autowired
    private DataValidateMapper dataValidateMapper;

    /**
     * 通过身份证校验年龄的定时任务
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        validateAllAge();
    }

    /**
     * 校验数据库所有人的年龄的任务：每隔1年执行一次
     */
    public void validateAllAge(){
        List<Map> allUser = dataValidateMapper.findAllUser();
        for (Map user: allUser){
            String uid = (String) user.get("uid");
            String idcard = (String) user.get("idcard");
            String birthday = ymd.format(user.get("birthday"));

            // 校验身份是否合法
            if (StaticUtils.verifyIDCard(idcard)){
                Map<String, String> birAgeSex = StaticUtils.getBirAgeSex(idcard);

                String mapBirth = birAgeSex.get("birthday");
                if (null != birthday && !mapBirth.equals(birthday)){
                    dataValidateMapper.updateBirthday(uid,mapBirth);
                }

            }else{
                //将不合法人员的信息查询出来
                Map iguser = dataValidateMapper.findByIdcard(idcard);
            }
        }

    }














}
