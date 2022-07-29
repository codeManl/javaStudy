package com.codemanl.processor;

import com.codemanl.entity.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("EvenEmpNoProcessor")
public class EvenEmpNoProcessor implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee item) throws Exception {
        if (item.getEmpNo() % 2 == 0) {
            System.out.println(item.getEmpNo());
            return item;
        } else {
            return null;
        }
    }
}
