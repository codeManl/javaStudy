package thread.consumerandproducer;

import thread.consumerandproducer.consumer.ConsumerBySynchronized;
import thread.consumerandproducer.producer.ProducerBySynchronized;

/**
 * @author liuele
 * @description
 * @date 2022/9/7 20:28:28
 */
public class TestWithSynchronized {
    public static void main(String[] args) {

            BufferArea bufferArea = new BufferArea();
            ProducerBySynchronized producer1 = new ProducerBySynchronized(bufferArea);
            ProducerBySynchronized producer2 = new ProducerBySynchronized(bufferArea);
            ProducerBySynchronized producer3 = new ProducerBySynchronized(bufferArea);

            ConsumerBySynchronized consumer1 = new ConsumerBySynchronized(bufferArea);
            ConsumerBySynchronized consumer2 = new ConsumerBySynchronized(bufferArea);
            ConsumerBySynchronized consumer3 = new ConsumerBySynchronized(bufferArea);


            new Thread(producer1, "生产者1").start();
            new Thread(producer2,"生产者2").start();
            new Thread(producer3,"生产者3").start();
            new Thread(consumer1,"消费者1").start();
            new Thread(consumer2,"消费者2").start();
            new Thread(consumer3,"消费者3").start();



    }
}
