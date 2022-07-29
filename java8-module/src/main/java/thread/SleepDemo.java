package thread;


import java.util.concurrent.TimeUnit;

/**
 * @author 刘乐乐
 * @description sleep测试
 * @date 2021/10/20 15:38
 */
public class SleepDemo {
    public static void main(String[] args){
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(() -> {
//            try {
//                System.out.println(System.currentTimeMillis());
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println(System.currentTimeMillis());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "t1").start();
//
//        long i = 1;
//        while (true) {
//            i += 1;
//        }
    }
}
