package thread.consumerandproducer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liulele
 * @description
 * @date 2022/9/7 20:07:07
 */
@Slf4j
public class BufferArea {

    private int max = 10;
    private int current = 0;

    /**
     * 生产操作
     */
    public synchronized void produce() {
        if (current < max) {
            current++;
            System.out.println(Thread.currentThread().getName() + " 生产了一件产品！当前产品数为：" + current);
            notifyAll();
        }else {
            try {
                System.out.println(Thread.currentThread().getName()+" 开始等待！当前仓库已满，产品数为："+current);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 消费
     */
    public synchronized void consume() {
        if (current >0) {
            current--;
            System.out.println(Thread.currentThread().getName()+" 获得了一件产品！当前产品数为："+current);
            notifyAll();
        }else {
            try {
                System.out.println(Thread.currentThread().getName()+" 开始等待！当前仓库为空，产品数为："+current);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
