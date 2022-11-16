package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.util.concurrent.TimeUnit;

/**
 * @author liulele
 * @description
 * @date 2022/8/27 16:47:47
 */
public interface CacheService {

    String get(final String key);
    void set(String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}
