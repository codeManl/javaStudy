package thread;

import sun.misc.Unsafe;

/**
 * @author 刘乐乐
 * @description 简单实现一把锁
 * @date 2021/11/12 20:23
 */
public class MyLock {
    /**
     * 锁的状态 为0时可以进入，为1时不可以进入
     */
    private int state = 0;

    private Unsafe unsafe = Unsafe.getUnsafe();

    /**
     * 加锁
     */
    public void lock() {
        // 使用cas来实现加锁
        while (!unsafe.compareAndSwapInt(state, 0, 0, 1)) {
        }
        Thread.currentThread().interrupt();
    }

    public void unlock() {
        state = 0;

    }

}
