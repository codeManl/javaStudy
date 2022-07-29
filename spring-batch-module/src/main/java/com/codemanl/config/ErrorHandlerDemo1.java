package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.batch.item.support.CompositeItemProcessor;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 错误处理
// */
//@Configuration
//public class ErrorHandlerDemo1 {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job errorHandlerJob() {
//        return jobBuilderFactory.get("errorHandlerJob")
//                .start(step1())
//                .next(step2())
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//
//        return stepBuilderFactory.get("step2")
//                .tasklet(errorHandlerTasklet())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(errorHandlerTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet errorHandlerTasklet() {
//
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                Map<String, Object> stepExecutionContext = chunkContext.getStepContext().getStepExecutionContext();
//                if (stepExecutionContext.containsKey("first")) {
//                    System.out.println("second will success");
//                    return RepeatStatus.FINISHED;
//                } else {
//                    chunkContext.getStepContext().getStepExecution().getExecutionContext().put("first", true);
//                    throw new RuntimeException("first will failed");
//                }
//            }
//        };
//    }
//
//
//}
