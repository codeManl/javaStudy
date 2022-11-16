package cn.liulele.structualpatterns.flyWeightPattern.example;

/**
 * @author liulele
 * @description
 * @date 2022/9/6 20:08:08
 */
public class ActivityController {
    private final RedisUtil redisUtil = new RedisUtil();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        Stock stock = new Stock(1000, redisUtil.getStock());
        activity.setStock(stock);
        return activity;
    }
}
