package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.util.concurrent.TimeUnit;

/**
 * @description 适配器接口
 * @author liuele
 * @date 2022/8/27 17:14:14
 */
public interface CacheAdapter {
    String get(final String key);
    void set(String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    String del(String  key);
}
