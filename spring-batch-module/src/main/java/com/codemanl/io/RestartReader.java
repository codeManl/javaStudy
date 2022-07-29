package com.codemanl.io;

import com.codemanl.entity.Employee;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * 自定义的可重启的reader
 */
@Component("RestartReader")
public class RestartReader implements ItemStreamReader<Employee> {
    private int count;

    private boolean restart = false;

    private FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();

    private ExecutionContext executionContext;

    public RestartReader() {
        // 设置文件路径
        flatFileItemReader.setResource(new ClassPathResource("employees.txt"));
        // 跳过第一行
        flatFileItemReader.setLinesToSkip(count);
        // 传递分隔符,不传则为 ','
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        // 设置每个字段的列名
        delimitedLineTokenizer.setNames("emp_no", "birth_date", "first_name", "last_name", "gender", "hire_date");

        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(new FieldSetMapper<Employee>() {
            @Override
            public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
                return Employee.builder()
                        .empNo(fieldSet.readInt("emp_no"))
                        .birthDate(fieldSet.readDate("birth_date"))
                        .firstName(fieldSet.readString("first_name"))
                        .lastName(fieldSet.readString("last_name"))
                        .gender(fieldSet.readString("gender"))
                        .hireDate(fieldSet.readDate("hire_date"))
                        .build();
            }
        });
        lineMapper.afterPropertiesSet();
        flatFileItemReader.setLineMapper(lineMapper);
    }

    @Override
    public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Employee employee = null;

        if (restart) {
            flatFileItemReader.setLinesToSkip(count);
            restart = false;
            System.out.println("开始执行,当前行: " + count);
        }


        flatFileItemReader.open(executionContext);
        employee = flatFileItemReader.read();

        if (employee != null) {
            if ("Berhard".equals(employee.getFirstName())) {
                throw new RuntimeException("错误的员工姓名, 员工id: " + employee.getEmpNo());
            }
            count++;
        }

        return employee;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        this.executionContext = executionContext;
        if (executionContext.containsKey("count")) {
            count = executionContext.getInt("count");
            this.restart = true;
        } else {
            executionContext.put("count", count);
        }

        System.out.println("开始执行,当前行: " + count);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("已执行行数: " + count);
        executionContext.put("count", count);
    }

    @Override
    public void close() throws ItemStreamException {
        System.out.println("执行结束,共读取行数: " + count);
    }
}
