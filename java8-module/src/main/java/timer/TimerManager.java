package timer;

import cn.hutool.core.lang.copier.Copier;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liuele
 * @description
 * @date 2022/9/5 20:23:23
 */
public class TimerManager {

    public TimerManager() {
        TimerTask timerTask = new FixedTimerTask();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 1000,2000);
    }

    public static void main(String[] args) {
        new TimerManager();
    }
}
