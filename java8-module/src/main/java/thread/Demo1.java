package thread;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 刘乐乐
 * @description 多线程练习
 * @date 2021/10/19 20:03
 */
public class Demo1 {
    public static void main(String[] args) throws ConcurrentModificationException {
//        Lock lock = new ReentrantLock();
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
//        list.add(1);
//        list.get(0);
//        list.addAll(new ArrayDeque<>());
//
//        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
//        set.add(1);

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
}
