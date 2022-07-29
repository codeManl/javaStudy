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
//public class JobLaunchDemoTwo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Step childTwoStepOne() {
//        return stepBuilderFactory.get("childTwoStepOne")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("childTwoStepOne");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public Step childTwoStepTwo() {
//        return stepBuilderFactory.get("childTwoStepTwo")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("childTwoStepTwo");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public Job childJob2() {
//        return jobBuilderFactory.get("childTwoJob")
//                .start(childTwoStepOne())
//                .next(childTwoStepTwo())
//                .build();
//    }
//}
