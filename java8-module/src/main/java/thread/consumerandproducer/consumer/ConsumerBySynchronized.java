package thread.consumerandproducer.consumer;

import thread.consumerandproducer.BufferArea;

/**
 * @author liulele
 * @description
 * @date 2022/9/7 20:02:02
 */
public class ConsumerBySynchronized implements Runnable {
    private BufferArea bufferArea;

    public ConsumerBySynchronized(BufferArea bufferArea) {
        this.bufferArea = bufferArea;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bufferArea.consume();
        }
    }
}
