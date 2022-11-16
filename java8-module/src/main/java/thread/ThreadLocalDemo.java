package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liulele
 * @description
 * @date 2022/9/16 10:37:37
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Map<String, Object>> mapThreadLocal =ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) throws InterruptedException {
        mapThreadLocal.remove();
        mapThreadLocal.set(new HashMap<>());


        Map<String, Object> thread1Map = mapThreadLocal.get();
        thread1Map.put("aaa", "bbb");

        System.out.println(mapThreadLocal.get());
        System.out.println(mapThreadLocal.get().get("aaa"));


//        mapThreadLocal.set(thread1Map);
        Thread.sleep(1000);

        new Thread(() -> {
            System.out.println(mapThreadLocal.get());
            System.out.println(mapThreadLocal.get().get("aaa"));
        }, "newThread").start();
    }
}
