package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description 单机模式下调用redis服务的工具类
 * @date 2022/8/27 16:37:37
 */
@Slf4j
public class RedisUtils<K, V> {

    private final Map<K, V> dataMap = new ConcurrentHashMap<>();

    public void set(K key, V value) {
        log.info("写入数据,key:" + key + ",value:" + value);
        dataMap.put(key, value);
    }

    public void setExpire(K key, V value, long timeout, TimeUnit timeUnit) {
        log.info("写入数据,key:" + key + ",value:" + value + ",过期时间:" + timeout + ",时间单位:" + timeUnit);
        dataMap.put(key, value);
    }

    public V get(K key) {
        log.info("读取数据,key:" + key);
        return dataMap.get(key);
    }

    public V delete(K key) {
        log.info("删除数据,key:" + key);
        return dataMap.remove(key);
    }
}
