package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
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
// * TWO
// */
//@Configuration
//public class JobFlowConfigurationDemoTwo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job helloWorldJob3() {
//        return jobBuilderFactory.get("helloWorldJob4").
//                start(flow1()).
//                next(step3()).end().
//                build();
//
//    }
//
//
//    @Bean
//    public Flow flow1() {
//        return new FlowBuilder<Flow>("flow1").
//                start(step1()).
//                from(step1()).on("COMPLETED").to(step2()).
//                build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").tasklet(((contribution, chunkContext) -> {
//            System.out.println("step1....");
//            return RepeatStatus.FINISHED;
//        })).build();
//    }
//
//
//    @Bean
//    public Step step2() {
//        return stepBuilderFactory.get("step2").tasklet(((contribution, chunkContext) -> {
//            System.out.println("step2....");
//            return RepeatStatus.FINISHED;
//        })).build();
//    }
//
//
//    @Bean
//    public Step step3() {
//        return stepBuilderFactory.get("step3").tasklet(((contribution, chunkContext) -> {
//            System.out.println("step3....");
//            return RepeatStatus.FINISHED;
//        })).build();
//    }
//}
