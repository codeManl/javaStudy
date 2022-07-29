package com.codemanl.biz.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobLaunchController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    @Qualifier("JobLaunchByControllerJob")
    private Job job;

    @GetMapping("/demo1/{msg}")
    public String jobLaunchDemo1(@PathVariable("msg") String msg) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        System.out.println(msg + ".......");

        JobParameters jobParameters = new JobParametersBuilder().addString("msg", msg).toJobParameters();
        jobLauncher.run(job, jobParameters);
        return msg;
    }
}
