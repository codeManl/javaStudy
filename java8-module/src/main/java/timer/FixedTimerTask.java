package timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author liulele
 * @description 不可修改的定时任务
 * @date 2022/9/5 20:19:19
 */
public class FixedTimerTask extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                Date d = new Date();
                System.out.println("已执行【" + (i + 1) + "】秒钟，at: " + d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("本次任务调度结束，at: " + new Date());
        System.out.println("---------------------------");
    }

}
