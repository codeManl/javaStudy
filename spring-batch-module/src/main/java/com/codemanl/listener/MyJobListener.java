package com.codemanl.listener;//package com.codemanl.listener;
//
//import org.springframework.batch.core.ChunkListener;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.StepExecutionListener;
//
///**
// * 监听器  job step chunk都有对应接口
// */
//public class MyJobListener implements JobExecutionListener {
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//        System.out.println(jobExecution.getJobInstance().getJobName()+ " before Job execute");
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        System.out.println(jobExecution.getJobInstance().getJobName()+ " after Job execute");
//    }
//}
