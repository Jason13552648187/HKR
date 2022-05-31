package cn.com.hkr.utils;

import cn.com.hkr.job.IdcardValidateAgeJob;
import cn.com.hkr.job.IdcardValidateBirthdayJob;
import cn.com.hkr.job.IdcardValidateSexJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author jason
 * @date 2022/4/14-11:10
 */

public class QuartzListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    //创建调度器
        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();

            //创建任务
            JobDetail validateSex = JobBuilder.newJob(IdcardValidateSexJob.class).storeDurably().withIdentity("AllCardSex","sex").build();
            JobDetail validateAge = JobBuilder.newJob(IdcardValidateAgeJob.class).storeDurably().withIdentity("AllCardAge","age").build();
            JobDetail validateBirth = JobBuilder.newJob(IdcardValidateBirthdayJob.class).storeDurably().withIdentity("ALLbirthday","birthday").build();

            //使用一览表构建器来创建触发器
            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("ageValidateTrigger","ageTriGroup1")
                    .startNow()
                    .forJob(validateAge)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 1 1 ?")).build();

            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("sexValidateTrigger","sexTriGroup1")
                    .startNow()
                    .forJob(validateSex)
                    .withSchedule(CronScheduleBuilder.cronSchedule("* * * * */6 ?")).build();


            Trigger trigger3 = TriggerBuilder.newTrigger()
                    .withIdentity("birthdayValidateTrigger","sexTriGroup1")
                    .startNow()
                    .forJob(validateBirth)
                    .withSchedule(CronScheduleBuilder.cronSchedule("* * * * */6 ?")).build();



            scheduler.addJob(validateAge,true);
            scheduler.addJob(validateSex,true);
            scheduler.addJob(validateBirth,true);

            scheduler.scheduleJob(trigger1);
            scheduler.scheduleJob(trigger2);
            scheduler.scheduleJob(trigger3);

            //启动
            if (!scheduler.isShutdown()){
                scheduler.start();
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
