package cn.com.hkr.test;

import cn.com.hkr.job.IdcardValidateAgeJob;
import cn.com.hkr.job.IdcardValidateSexJob;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author jason
 * @date 2022/3/7-23:36
 */
public class Quartz {

    public static void main(String[] args) throws SchedulerException {

        //创建调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(JobImpl.class).withIdentity("jason", "admin").build();
        JobDetail validateSex = JobBuilder.newJob(IdcardValidateSexJob.class).storeDurably().withIdentity("AllCardSex","sex").build();
        JobDetail validateAge = JobBuilder.newJob(IdcardValidateAgeJob.class).storeDurably().withIdentity("AllCardAge","age").build();


        //使用一览表构建器来创建触发器
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("t1","i1")
                .startNow()
                .forJob(validateAge)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?")).build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("t2","i1")
                .startNow()
                .forJob(validateSex)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?")).build();


        //将任务job和定时触发器绑定 放入到任务一览表
//        scheduler.scheduleJob(jobDetail,triggerBuilder);
//        scheduler.scheduleJob(validateAge,trigger1);
//        scheduler.scheduleJob(validateAge,trigger2);


        scheduler.addJob(validateAge,true);
        scheduler.addJob(validateSex,true);
        scheduler.scheduleJob(trigger1);
        scheduler.scheduleJob(trigger2);

        //启动
        if (!scheduler.isShutdown()){
            scheduler.start();
        }



    }



}
