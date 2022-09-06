package cn.liulele.structualpatterns;

import cn.liulele.structualpatterns.flyWeightPattern.example.Activity;
import cn.liulele.structualpatterns.flyWeightPattern.example.ActivityController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 20:11:11
 */
@Slf4j
public class FlyWeightPatternTest {

    @Test
    public void test01() throws InterruptedException {
        ActivityController activityController = new ActivityController();
        for (int i = 0; i < 100; i++) {
            Activity activity = activityController.queryActivityInfo(100L);
            log.info(activity.toString());
            Thread.sleep(2000);
        }
    }
}
