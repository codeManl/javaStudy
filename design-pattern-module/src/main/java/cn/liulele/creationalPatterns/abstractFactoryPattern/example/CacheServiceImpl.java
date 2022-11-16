package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description
 * @date 2022/8/27 17:12:12
 */
public class CacheServiceImpl implements CacheService {

    public RedisUtils<String, String> redisUtils = new RedisUtils<>();

    @Override

    public String get(String key) {

        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.delete(key);
    }
}
