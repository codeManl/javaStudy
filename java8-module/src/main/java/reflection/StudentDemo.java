package reflection;

import java.lang.reflect.Method;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(11);
        student.setName("aa");

        Class<? extends Student> clazz = student.getClass();
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }


    }
}
