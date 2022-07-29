package com.codemanl.config;//package com.codemanl.config;
//
//import javafx.concurrent.Task;
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
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//
///**
// * 用split
// * 配置一个job中多个flow 异步执行
// */
//@Configuration
//public class JobSpilitDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job helloWorldJob5() {
//        return jobBuilderFactory.get("helloWorldJob5")
//                .start(flow1())
//                .split(new SimpleAsyncTaskExecutor()).add(flow2())
//                .end()
//                .build();
//    }
//
//
//    @Bean
//    public Flow flow1() {
//        return new FlowBuilder<Flow>("flow1").
//                start(stepBuilderFactory.get("step1").tasklet(tasklet()).build()).
//                build();
//    }
//
//    @Bean
//    public Flow flow2() {
//        return new FlowBuilder<Flow>("flow2").
//                start(stepBuilderFactory.get("step2").tasklet(tasklet()).build()).
//                next(stepBuilderFactory.get("step3").tasklet(tasklet()).build()).
//                build();
//    }
//
//    @Bean
//    public Tasklet tasklet() {
//        return new TaskletImpl();
//    }
//
//    private class TaskletImpl implements Tasklet {
//
//        @Override
//        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//            System.out.printf(" %s has been executed on thread %s%n", chunkContext.getStepContext().getStepName(), Thread.currentThread().getName());
//            return RepeatStatus.FINISHED;
//        }
//    }
//}
