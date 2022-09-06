package cn.liulele.creationalPatterns.abstractFactoryPattern.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuele
 * @description
 * @date 2022/8/27 21:04:04
 */
public class JDKProxyInvocationHandler implements InvocationHandler {
    private CacheAdapter cacheAdapter;

    public JDKProxyInvocationHandler(CacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] clazzByArgs = ClassLoaderUtils.getClazzByArgs(args);
        return CacheAdapter.class.getMethod(methodName, clazzByArgs).invoke(cacheAdapter, args);
    }
}
