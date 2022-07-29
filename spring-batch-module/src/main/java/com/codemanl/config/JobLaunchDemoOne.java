package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class JobLaunchDemoOne {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Step childOneStepOne() {
//        return stepBuilderFactory.get("childOneStepOne")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("childOneStepOne");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public Job childJob1() {
//        return jobBuilderFactory.get("childOneJob")
//                .start(childOneStepOne())
//                .build();
//    }
//}
