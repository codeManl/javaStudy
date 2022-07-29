package entity;

import annotation.MyDateFormat;
import lombok.*;

/**
 * Person实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Person extends Parent {
    /**
     * 姓名
     */
    @NonNull
    private String name;
    /**
     * 薪资
     */
    @NonNull
    private int salary;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    @NonNull
    private String sex;
    /**
     * 地区
     */
    @NonNull
    private String area;

    /**
     * 业务日期
     */
    @MyDateFormat
    private String settleDate;

}
