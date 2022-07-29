package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘乐乐
 * @description CountDownLatch类练习
 *  await()方法,暂停当前线程，只有当countDownLatch的值为0 才开始执行
 *  await(参数)方法,暂停当前线程，只有当countDownLatch的值为0 才开始执行,或者等待参数时间后开始执行
 * @date 2021/10/19 21:43
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
//        countDownLatch.countDown();
//        System.out.println(countDownLatch.getCount());
//        new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println("1号离开了房间...");
//                countDownLatch.countDown();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "1").start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("2号离开了房间...");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("3号离开了房间...");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("4号离开了房间...");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "4").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("5号离开了房间...");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "5").start();
        new Thread(() -> {
            try {
                System.out.println("班长准备离开...");
                countDownLatch.await(10, TimeUnit.SECONDS);
                System.out.println("班长离开了房间...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "班长离开了房间").start();

    }
}
