package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)
            throws InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException {
        // 调用无参构造
        Person person = Person.class.newInstance();
        Person person2 = Person.class.getConstructor().newInstance();
        System.out.println("-----------------------------------");
        // 调用有参构造
        Person person1 = Person.class.getConstructor(String.class).newInstance("张三");
        System.out.println("-----------------------------------");

        // 下面这段代码证明了反射创建对象的效率很低
        /*        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            new Person("张三" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Person.class.getConstructor(String.class).newInstance("张三" + i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);*/
    }
}
