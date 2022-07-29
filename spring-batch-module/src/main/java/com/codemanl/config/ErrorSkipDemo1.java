package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.SkipListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 错误处理
// * 重试
// */
//@Configuration
//public class ErrorSkipDemo1 {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("ErrorRetryProcessor")
//    private ItemProcessor<String, String> itemProcessor;
//    @Autowired
//    @Qualifier("ErrorSkipListener")
//    private SkipListener<? super String, ? super String> skipListener;
//
//    @Bean
//    public Job errorRetryJob() {
//        return jobBuilderFactory.get("errorSkipJob1")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<String, String>chunk(10)
//                .reader(reader())
//                .processor(itemProcessor)
//                .writer(writer())
//                // 声明是有容错能力的
//                .faultTolerant()
//                // 当抛出什么异常时会跳过
//                .skip(Exception.class)
//                // 跳过总条数，如果累计跳过了3条，则停止运行
//                .skipLimit(3)
//                .listener(skipListener)
//                .build();
//    }
//
//    @Bean
//    public ItemWriter<? super String> writer() {
//        return new ItemWriter<String>() {
//            @Override
//            public void write(List<? extends String> items) throws Exception {
//                System.out.println("write start....");
//                for (String item : items) {
//                    System.out.println(item);
//                }
//                System.out.println("write end....");
//            }
//        };
//    }
//
//
//    @Bean
//    public ItemReader<String> reader() {
//
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            list.add(String.valueOf(i));
//        }
//        return new ListItemReader<>(list);
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
