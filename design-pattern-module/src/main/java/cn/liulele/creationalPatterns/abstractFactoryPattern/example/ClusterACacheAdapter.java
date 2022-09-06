package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.util.concurrent.TimeUnit;

/**
 * @author liuele
 * @description
 * @date 2022/8/27 20:43:43
 */
public class ClusterACacheAdapter implements CacheAdapter {
    private final ClusterA cluster = new ClusterA();

    @Override
    public String get(String key) {
        return cluster.getValue(key);
    }

    @Override
    public void set(String key, String value) {
        cluster.put(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        cluster.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public String del(String key) {
        return cluster.deleteByKey(key);
    }
}
