package com.codemanl.processor;

import com.codemanl.entity.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("ToUpperCaseFirstNameProcessor")
public class ToUpperCaseFirstNameProcessor implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee item) throws Exception {
        System.out.println(item.getFirstName());
        return new Employee(item.getEmpNo(), item.getBirthDate(), item.getFirstName().toUpperCase(), item.getLastName(), item.getGender(), item.getHireDate());
    }
}