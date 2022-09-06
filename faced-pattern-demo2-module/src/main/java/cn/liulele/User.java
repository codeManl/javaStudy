package cn.liulele;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liuele
 * @description
 * @date 2022/8/16 22:36:36
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;
    private String address;
    private String code;
    private String info;

    public User(String id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
