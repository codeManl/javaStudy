package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description 集群B使用的redis工具类
 * @date 2022/8/27 16:35:35
 */
@Slf4j
public class ClusterB {

    private final Map<String , String> dataMap = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        log.info("集群B写入数据,key:" + key + ",value:" + value);
        dataMap.put(key, value);
    }

    public void setWithExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("集群B写入数据,key:" + key + ",value:" + value + ",过期时间:" + timeout + ",时间单位:" + timeUnit);
        dataMap.put(key, value);
    }

    public String getValue(String key) {
        log.info("集群B读取数据,key:" + key);
        return dataMap.get(key);
    }

    public String deleteByKey(String key) {
        log.info("集群B删除数据,key:" + key);
        return dataMap.remove(key);
    }
}
