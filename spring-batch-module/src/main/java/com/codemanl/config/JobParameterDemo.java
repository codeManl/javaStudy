package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
///**
// * Job Paramater 学习
// * 通过命令行中指定参数来传入job
// */
//@Configuration
//public class JobParameterDemo implements JobExecutionListener {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    Map<String, JobParameter> parameters;
//
//    @Bean
//    public Job JobParameterDemoJob() {
//        return jobBuilderFactory.get("JobParameterDemoJob2")
//                .listener(this)
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println(parameters.get("info"));
//                    return RepeatStatus.FINISHED;
//
//                }))
//                .build();
//    }
//
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//        parameters = jobExecution.getJobParameters().getParameters();
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//
//    }
//}
