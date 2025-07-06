package com.itersdesktop.javatechs.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob implements Job {
    final static Logger LOGGER = LoggerFactory.getLogger(MyJob.class);

    // need a constructor without arguments
    public MyJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        long userId = dataMap.getLongFromString("userId");
        LOGGER.info("MyJob started for the userId {}.", userId);
        System.out.println("MyJob started for the userId " + userId);
    }
}
