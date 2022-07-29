package com.codemanl.entity;

import lombok.*;

import java.util.Date;

/**
 * 员工实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee  {
    /**
     * 员工编号
     */
    private Integer empNo;
    /**
     * 员工生日
     */
    private Date birthDate;
    /**
     * first name
     */
    private String firstName;
    /**
     * last name
     */
    private String lastName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 雇佣日期
     */
    private Date hireDate;
}
