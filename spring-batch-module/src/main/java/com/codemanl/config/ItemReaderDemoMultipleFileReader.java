package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.mapping.FieldSetMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FieldSet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.validation.BindException;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * ItemReader学习
// * 从多个文件中读取数据
// */
//@Configuration
//public class ItemReaderDemoMultipleFileReader {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Value("classpath*:/employee*.txt")
//    private Resource[] files;
//
//    @Bean
//    public Job itemReaderDemoMultipleFileReaderJob() {
//        return jobBuilderFactory.get("itemReaderDemoMultipleFileReaderJob2")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Employee, Employee>chunk(50)
//                .reader(multipleRead())
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
//    /**
//     * 读多个文件就是将多个文件分开读(setDelegate())
//     */
//    public ItemReader<Employee> multipleRead() {
//        MultiResourceItemReader<Employee> multiResourceItemReader = new MultiResourceItemReader<>();
//        multiResourceItemReader.setResources(files);
//        multiResourceItemReader.setDelegate(read());
//
//        return multiResourceItemReader;
//    }
//
//    @Bean
//    public FlatFileItemReader<Employee> read() {
//        FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setLinesToSkip(1);
//        // 传递分隔符,不传则为 ','
//        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
//        // 设置每个字段的列名
//        delimitedLineTokenizer.setNames("emp_no", "birth_date", "first_name", "last_name", "gender", "hire_date");
//
//        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
//        lineMapper.setLineTokenizer(delimitedLineTokenizer);
//        lineMapper.setFieldSetMapper(new FieldSetMapper<Employee>() {
//            @Override
//            public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
//                return Employee.builder()
//                        .empNo(fieldSet.readInt("emp_no"))
//                        .birthDate(fieldSet.readDate("birth_date"))
//                        .firstName(fieldSet.readString("first_name"))
//                        .lastName(fieldSet.readString("last_name"))
//                        .gender(fieldSet.readString("gender"))
//                        .hireDate(fieldSet.readDate("hire_date"))
//                        .build();
//            }
//        });
//        lineMapper.afterPropertiesSet();
//
//        flatFileItemReader.setLineMapper(lineMapper);
//
//        return flatFileItemReader;
//    }
//}
