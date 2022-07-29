package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.apache.ibatis.executor.result.DefaultMapResultHandler;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FieldSet;
//import org.springframework.batch.item.xml.StaxEventItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
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
// * 从XML文件中读取数据
// */
//@Configuration
//public class ItemReaderDemoXMLReader {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job itemReaderDemoXMLReaderJob() {
//        return jobBuilderFactory.get("itemReaderDemoXMLReaderJob")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Employee, Employee>chunk(50)
//                .reader(read())
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
//    @Bean
//    public ItemReader<Employee> read() {
//        StaxEventItemReader<Employee> staxEventItemReader = new StaxEventItemReader<>();
//        // 设置文件路径
//        staxEventItemReader.setResource(new ClassPathResource("employees.txt"));
//        staxEventItemReader.setFragmentRootElementName("row");
//
//
////        staxEventItemReader.setUnmarshaller();
//
//
//        return staxEventItemReader;
//    }
//}
