package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 刘乐乐
 * @description ReentrantLock可重入锁学习
 * @date 2021/11/12 20:10
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        try {
            // ...
        } finally {
            lock.unlock();
        }
    }
}
