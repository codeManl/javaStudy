package cn.liulele;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuele
 * @description 外观模式门面注解，此注解会被添加到需要添加扩展白名单的方法上
 * @date 2022/8/16 22:00:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoDoor {
    /**
     * 字段名
     */
    String key() default "";

    /**
     *
     * @return 具体内容
     */
    String returnJson() default "";
}
