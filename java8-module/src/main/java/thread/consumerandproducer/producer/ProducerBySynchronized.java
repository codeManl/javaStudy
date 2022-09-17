package thread.consumerandproducer.producer;

import thread.consumerandproducer.BufferArea;

/**
 * @author liuele
 * @description
 * @date 2022/9/7 20:03:03
 */
public class ProducerBySynchronized implements Runnable {
    private BufferArea bufferArea;

    public ProducerBySynchronized(BufferArea bufferArea) {
        this.bufferArea = bufferArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bufferArea.produce();
        }
    }
}
