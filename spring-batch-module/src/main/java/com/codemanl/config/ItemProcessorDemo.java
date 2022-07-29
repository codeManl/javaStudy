package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.batch.item.support.CompositeItemProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
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
// * ItemProcessor 学习
// * 从文件读取 进行处理  存入数据库
// */
//@Configuration
//public class ItemProcessorDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("EvenEmpNoProcessor")
//    private ItemProcessor<Employee,Employee> itemProcessor1;
//
//    @Autowired
//    @Qualifier("ToUpperCaseFirstNameProcessor")
//    private ItemProcessor<Employee,Employee> itemProcessor2;
//
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public Job itemProcessorDemoJob() {
//        return jobBuilderFactory.get("itemProcessorDemoJob4")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Employee, Employee>chunk(50)
//                .reader(read())
//                // 可以传多个processor 不能同时使用
//                .processor(multProcessor())
////                // 也可以传一个processor
////                .processor(new ItemProcessor<Employee, Employee>() {
////                    @Override
////                    public Employee process(Employee item) throws Exception {
////                        return item;
////                    }
////                })
//                .writer(write())
//                .build();
//    }
//
//    /**
//     * 如果有多个processor
//     * 可以使用CompositeItemProcessor
//     */
//    @Bean
//    public ItemProcessor<? super Employee, ? extends Employee> multProcessor() {
//        CompositeItemProcessor<Employee, Employee> compositeItemProcessor = new CompositeItemProcessor<>();
//
//        List<ItemProcessor<Employee, Employee>> list = new ArrayList<>();
//        list.add(itemProcessor1);
//        list.add(itemProcessor2);
//
//        compositeItemProcessor.setDelegates(list);
//        return compositeItemProcessor;
//    }
//
//    @Bean
//    public ItemWriter<? super Employee> write() {
//        JdbcBatchItemWriter<Employee> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();
//        jdbcBatchItemWriter.setDataSource(dataSource);
//        jdbcBatchItemWriter.setSql("insert into employees2(emp_no,birth_date,first_name,last_name,gender,hire_date) " +
//                "values(:empNo,:birthDate,:firstName,:lastName,:gender,:hireDate)");
//        jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return jdbcBatchItemWriter;
//    }
//
//    @Bean
//    public ItemReader<Employee> read() {
//        JdbcPagingItemReader<Employee> jdbcReader = new JdbcPagingItemReader<>();
//        jdbcReader.setDataSource(dataSource);
//        // 设置分页  分页设为100 chunk设为50 意思是每次read100条，然后这100条write的时候每次50条，共两次调用
//        jdbcReader.setFetchSize(100);
//        jdbcReader.setRowMapper(new RowMapper<Employee>() {
//                                    @Override
//                                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//                                        Employee employee = Employee.builder()
//                                                .empNo(rs.getInt("emp_no"))
//                                                .birthDate(rs.getDate("birth_date"))
//                                                .firstName(rs.getString("first_name"))
//                                                .lastName(rs.getString("last_name"))
//                                                .gender(rs.getString("gender"))
//                                                .hireDate(rs.getDate("hire_date"))
//                                                .build();
//
//                                        return employee;
//                                    }
//                                }
//        );
//        MySqlPagingQueryProvider mysqlQueryProvider = new MySqlPagingQueryProvider();
//        mysqlQueryProvider.setSelectClause("emp_no,birth_date,first_name,last_name,gender,hire_date");
//        mysqlQueryProvider.setFromClause("from employees");
////        where 条件
////        mysqlQueryProvider.setWhereClause();
//        // sql排序
//        Map<String, Order> map = new HashMap<>(2);
//        map.put("emp_no", Order.DESCENDING);
//        mysqlQueryProvider.setSortKeys(map);
//
//        jdbcReader.setQueryProvider(mysqlQueryProvider);
//        return jdbcReader;
//    }
//
//
//}
