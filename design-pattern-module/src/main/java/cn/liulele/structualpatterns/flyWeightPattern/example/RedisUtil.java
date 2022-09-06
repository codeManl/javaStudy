package cn.liulele.structualpatterns.flyWeightPattern.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 20:04:04
 */
public class RedisUtil {
    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private final AtomicInteger stock = new AtomicInteger(0);

    public RedisUtil() {

        service.scheduleAtFixedRate(() -> {
            stock.addAndGet(1);
        },0,1000, TimeUnit.MILLISECONDS);

    }
    public  Integer getStock() {
        return stock.get();
    }
}
