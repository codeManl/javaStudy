package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description
 * @date 2022/8/27 20:45:45
 */
public class ClusterBCacheAdapter implements CacheAdapter {
    ClusterB cluster = new ClusterB();

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
        cluster.setWithExpire(key, value, timeout, timeUnit);
    }

    @Override
    public String del(String key) {
        return cluster.deleteByKey(key);
    }
}
