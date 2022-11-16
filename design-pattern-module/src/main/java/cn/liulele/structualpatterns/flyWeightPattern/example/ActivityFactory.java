package cn.liulele.structualpatterns.flyWeightPattern.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liulele
 * @description
 * @date 2022/9/6 19:45:45
 */
public class ActivityFactory {

    static Map<Long, Activity> map = new HashMap<>();

    public static Activity getActivity(Long id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setName("name");
        activity.setDesc("desc");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        map.put(id, activity);

        return activity;
    }

}
