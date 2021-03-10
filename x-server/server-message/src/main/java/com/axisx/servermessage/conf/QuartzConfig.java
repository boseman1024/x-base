package com.axisx.servermessage.conf;

import com.axisx.servermessage.task.PushWatchJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail pushWatchJobDetail(){
        JobDetail jobDetail = JobBuilder
                .newJob(PushWatchJob.class)
                .withIdentity("PushWatchJob", "MESSAGE_JOB")
                .storeDurably()
                .build();
        return jobDetail;
    }
    @Bean
    public Trigger myTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(pushWatchJobDetail())
                .withIdentity("PushWatchJobTrigger", "MESSAGE_TRIGGER")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(180)
                                .repeatForever()
                ).build();
        return trigger;
    }
}
