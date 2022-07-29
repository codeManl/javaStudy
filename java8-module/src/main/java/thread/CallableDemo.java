package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 刘乐乐
 * @description Callable学习
 * @date 2021/10/19 21:03
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Resource());
        new Thread(futureTask, "aaa").start();
        System.out.println(Thread.currentThread().getName() + "。。。");

        System.out.println(futureTask.get());

    }
}

class Resource implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        Thread.sleep(4000);
        System.out.println("call()方法被执行了...");
        return 2;
    }
}
