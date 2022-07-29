package thread.BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘乐乐
 * @description ArrayBlockingQueue练习
 * 数组结构的阻塞队列
 * <p>
 * 检查
 * element()方法检查队列首部元素,如果队列没有·元素，抛异常Exception in thread "main" java.util.NoSuchElementException
 * peek()检查队首有元素则返回元素，没有元素则返回null
 * <p>
 * 存取
 * 使用add()方法插入时超出最大容量会抛异常Exception in thread "main" java.lang.IllegalStateException: Queue full
 * 使用remove()方法移除元素，当没有元素时会抛异常 Exception in thread "main" java.util.NoSuchElementException
 * <p>
 * offer()添加元素成功返回true,失败返回false
 * poll()移除元素成功返回元素，失败返回null
 * <p>
 * put()添加元素时超出容量会阻塞,直到有容量时继续添加
 * take()拿不到元素时会阻塞线程，直到它拿到元素
 * <p>
 * poll(time,unit) 取出元素时如果队列为空则等待指定参数时间,仍无法取到元素则返回null
 * offer(obj,time,unit)添加元素时如果队列已满则等待指定参数时间,如果仍没有添加进去，则不添加，返回false
 * @date 2021/11/1 21:30
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

/*        //  使用add()方法插入时超出最大容量会抛异常Exception in thread "main" java.lang.IllegalStateException: Queue full
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
//        System.out.println(queue.add("d"));
        // element()方法检查队列首部元素,如果队列没有·元素，抛异常Exception in thread "main" java.util.NoSuchElementException
        System.out.println(queue.element());
        // 使用remove()方法移除元素，当没有元素时会抛异常 Exception in thread "main" java.util.NoSuchElementException
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());
        System.out.println(queue.element());*/

/*        // offer()添加元素成功返回true,失败返回false
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("a"));
        // poll()移除元素成功返回元素，失败返回null
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        // peek()检查队首有元素则返回元素，没有元素则返回null
        System.out.println(queue.peek());*/



        /*        try {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    // take()拿不到元素时会阻塞线程，直到它拿到元素
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            // put()添加元素时超出容量会阻塞,直到有容量时继续添加
            queue.put("a");
            queue.put("b");
            queue.put("c");
            queue.put("d");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("put结束了...");
        }*/

        /*      try {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    // poll(time,unit) 取出元素时如果队列为空则等待指定参数时间,仍无法取到元素则返回null
                    System.out.println(queue.poll(1, TimeUnit.SECONDS));
                    System.out.println(queue.poll(1, TimeUnit.SECONDS));
                    System.out.println(queue.poll(1, TimeUnit.SECONDS));
                    System.out.println(queue.poll(1, TimeUnit.SECONDS));
                    System.out.println(queue.poll(1, TimeUnit.SECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            // offer(obj,time,unit)添加元素时如果队列已满则等待指定参数时间,如果仍没有添加进去，则不添加，返回false
            System.out.println(queue.offer("a", 1, TimeUnit.SECONDS));
            System.out.println(queue.offer("a", 1, TimeUnit.SECONDS));
            TimeUnit.SECONDS.sleep(2);
            System.out.println(queue.offer("a", 1, TimeUnit.SECONDS));
            System.out.println(queue.offer("a", 1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
