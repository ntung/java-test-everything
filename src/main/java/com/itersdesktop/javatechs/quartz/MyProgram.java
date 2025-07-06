package com.itersdesktop.javatechs.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProgram {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyProgram.class);

    public static void run() throws SchedulerException, InterruptedException {
        System.out.println("Test Quartz Scheduler");
        call2MyJob();
    }

    private static void call2MyJob() throws SchedulerException, InterruptedException {
        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // JobDetailImpl is deprecated, so it is replaced with JobBuilder.newJob()
        // JobDetail jobDetail = new JobDetailImpl('UnlockAccountJob', 'group1', UnlockAccountJob)
        JobDataMap dataMap = new JobDataMap();
        long userId = 1234;
        int interval = 1;
        dataMap.putAsString("userId", userId);
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("unlockAccount")
                .usingJobData(dataMap)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("trigger1", "group1"))
                //.startNow()
                //.startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.HOUR))
                .startAt(DateBuilder.futureDate(interval, DateBuilder.IntervalUnit.MINUTE))
                /*.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withRepeatCount(0)
                    .withIntervalInMinutes(60))*/
                //.withSchedule(SimpleSchseduleBuilder.repeatSecondlyForever(10))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        LOGGER.info("The user {} will be unlocked after {} minutes",  userId, interval);
        System.out.println("The user " + userId + " will be unlocked after " + interval + " minutes");
        /* If we use quartz for web based apps, we don't have to start and shutdown the scheduler */
        scheduler.start();
        System.out.println("--- started scheduler ---");
        System.out.println("--- waiting for " + interval + " minutes ---");
        Thread.sleep(interval * 60 * 1_000); // 1 seconds = 1000 milliseconds; so 2 minutes = 2*60*1000
        System.out.println("--- stopped scheduler ---");
        scheduler.shutdown();
        System.out.println("--- shutting down scheduler completely ---");
    }
}
