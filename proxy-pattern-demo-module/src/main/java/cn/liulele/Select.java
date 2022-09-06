package cn.liulele;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuele
 * @description
 * @date 2022/8/22 19:42:42
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)

public @interface Select {

    String value();
}
