package thread.consumerandproducer;

import thread.consumerandproducer.consumer.ConsumerByBlockQueue;
import thread.consumerandproducer.producer.ProducerByBlockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuele
 * @description
 * @date 2022/9/8 11:51:51
 */
public class TestWithBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 创建阻塞队列
         */
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);

        /*
         * 创建生产者和消费者
         */
        ProducerByBlockQueue producer1 = new ProducerByBlockQueue(queue);
        ProducerByBlockQueue producer2 = new ProducerByBlockQueue(queue);
        ProducerByBlockQueue producer3 = new ProducerByBlockQueue(queue);

        ConsumerByBlockQueue consumer = new ConsumerByBlockQueue(queue);

        /*
         * 创建线程
         */
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);
        Thread.sleep(10000);
        //停止生产
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(2000);
        service.shutdown();
    }
}
