package com.codemanl.config;//package com.codemanl.config;
//
//import com.codemanl.entity.Employee;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * ItemReader学习
// * 从数据库读数据
// */
//@Configuration
//public class ItemReaderDemoJdbcReader {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public Job itemReaderDemoJdbcReaderJob() {
//        return jobBuilderFactory.get("ItemReaderDemoJdbcReaderJob3")
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
//}
