package cn.liulele.creationalPatterns.singleton;

/**
 * 单例设计模式的学习
 */
public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Person.getInstance());
                System.out.println(Person2.getInstance());
            }, String.valueOf(i)).start();
        }
    }
}
