package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuele
 * @description
 * @date 2022/8/27 20:51:51
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, CacheAdapter cacheAdapter) {
        JDKProxyInvocationHandler jdkProxyInvocationHandler = new JDKProxyInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader,classes, jdkProxyInvocationHandler);
    }


}
