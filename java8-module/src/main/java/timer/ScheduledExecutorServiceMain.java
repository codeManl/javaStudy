package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description
 * @date 2022/9/6 15:20:20
 */
public class ScheduledExecutorServiceMain {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> System.out.println("000"), 2, 1,TimeUnit.SECONDS);
    }
}
