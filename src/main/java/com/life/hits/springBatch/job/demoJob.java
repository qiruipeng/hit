package com.life.hits.springBatch.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * SpringBatch demo
 * @author: qirp
 * @since: 2018/6/22 16:00
 **/
public class demoJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
