package cn.com.hkr.test;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author jason
 * @date 2022/3/9-12:01
 */
@Component
@DisallowConcurrentExecution
public class JobImpl implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello world,这是一个新的任务代码！");
    }
}
