package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.decider.MyDecider;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.flow.JobExecutionDecider;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 使用决策器来判断执行顺序
// */
//@Configuration
//public class JobDeciderDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job job1() {
//        return jobBuilderFactory.get("job15")
//                .start(firstStep())
//                .next(myDecider())
//                .from(myDecider()).on("odd").to(oddStep())
//                .from(oddStep()).on("*").to(myDecider())
//                .from(myDecider()).on("even").to(evenStep())
//                .from(oddStep()).on("*").to(myDecider())
//                .end().build();
//    }
//
//    @Bean
//    public Step firstStep() {
//        return stepBuilderFactory.get("firstStep")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("firstStep");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public Step oddStep() {
//        return stepBuilderFactory.get("oddStep")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("oddStep");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public Step evenStep() {
//        return stepBuilderFactory.get("evenStep")
//                .tasklet(((contribution, chunkContext) -> {
//                    System.out.println("evenStep");
//                    return RepeatStatus.FINISHED;
//                })).build();
//    }
//
//    @Bean
//    public JobExecutionDecider myDecider() {
//        return new MyDecider();
//    }
//
//
//}
