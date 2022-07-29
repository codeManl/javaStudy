package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemStreamReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FieldSet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.validation.BindException;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * ItemReader学习
// * 抛出异常后下次重启时会接着上次未读取的继续读
// */
//@Configuration
//public class ItemReaderRestartReader {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("RestartReader")
//    private ItemStreamReader<Employee> itemStreamReader;
//
//    @Bean
//    public Job itemReaderDemoRestartReaderJob() {
//        return jobBuilderFactory.get("itemReaderDemoRestartReaderJob6")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Employee, Employee>chunk(50)
//                .reader(itemStreamReader)
//                .writer(write())
//                .build();
//    }
//
//    @Bean
//    public ItemWriter<? super Employee> write() {
//        return new ItemWriter<Employee>() {
//            @Override
//            public void write(List<? extends Employee> items) throws Exception {
//                for (Employee employee : items) {
//                    System.out.println(employee);
//                }
//                System.out.println("===============================");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//    }
//
//}
