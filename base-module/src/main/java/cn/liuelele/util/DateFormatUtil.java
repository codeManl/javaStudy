package cn.liuelele.util;

import cn.liuelele.annotation.MyDateFormat;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
public class DateFormatUtil<E> {

    public void dateFormat(E e) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = e.getClass();
        Field[] fields = clazz.getDeclaredFields();

        method1(fields, e);
        Class<?> superclass = clazz.getSuperclass();
        Field[] superFields = superclass.getDeclaredFields();
        method1(superFields, e);
    }

    private void method1(Field[] fields, E e) throws IllegalAccessException {
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyDateFormat.class)) {
                field.setAccessible(true);
                String s = field.get(e).toString();
                field.set(e, s.replace("-", ""));
            }
        }
    }
}
