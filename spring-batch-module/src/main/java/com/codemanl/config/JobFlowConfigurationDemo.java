package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 用flow来
// * 配置一个job中多个step
// */
//@Configuration
//public class JobFlowConfigurationDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job helloWorldJob2() {
//        // from on to 结构
//        return jobBuilderFactory.get("helloWorldJob1").
//                start(step2()).
//                on("COMPLETED").to(step3()).
//                from(step3()).on("COMPLETED").to(step4()).
//                from(step4()).end().
//                build();
//    }
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2").
//                tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
//                            throws Exception {
//                        System.out.println("step2........");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3").
//                tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
//                            throws Exception {
//                        System.out.println("step3........");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step step4() {
//        return stepBuilderFactory.get("step4").
//                tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
//                            throws Exception {
//                        System.out.println("step4........");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").
//                tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
//                            throws Exception {
//                        System.out.println("step1........");
//                        return RepeatStatus.FINISHED;
//                    }
//                }).build();
//    }
//}
