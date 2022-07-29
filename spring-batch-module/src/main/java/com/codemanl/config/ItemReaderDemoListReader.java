package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.io.ListReader1;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * ItemReader学习
// * 从list中读数据
// */
//@Configuration
//public class ItemReaderDemoListReader {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job ItemReaderDemoJob() {
//        return jobBuilderFactory.get("ItemReaderDemoJob")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<String, String>chunk(2)
//                .reader(read())
//                .writer(write())
//                .build();
//    }
//
//    private ItemWriter<? super String> write() {
//        return items -> {
//            for (String item : items) {
//                System.out.println(item + "...");
//            }
//        };
//    }
//
//    private ItemReader<String> read() {
//        List<String> data = Arrays.asList("a", "b", "c", "d", "e");
//        return new ListReader1(data);
//    }
//}
