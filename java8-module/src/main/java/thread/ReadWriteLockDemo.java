package thread;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @author 刘乐乐
 * @description ReadWriteLock 读写锁
 * 读的时候不加锁，写的时候加锁(不能写也不能读)
 * @date 2021/11/1 20:45
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(String.valueOf(tempInt), String.valueOf(tempInt));
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tempInt));
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 缓存资源类
 */
class MyCache {
    private volatile HashMap<String, String> map = new HashMap<>(16);

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取数据");
            TimeUnit.SECONDS.sleep(1);
            String value = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成,结果为" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }


    }

    public void put(String key, String value) {

        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入数据");
            TimeUnit.SECONDS.sleep(1);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }

    }
}
