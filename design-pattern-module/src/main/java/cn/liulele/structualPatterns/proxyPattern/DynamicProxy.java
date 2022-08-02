package cn.liulele.structualPatterns.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 * @author 刘乐乐
 * @description 动态代理案例
 * @date 2022-04-07 11:21:12
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Producer producer = new SubProducer();
        Producer proxyInstance = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new ProxyInvocationHandler(producer));
        proxyInstance.saleComputer(new BigDecimal("100"));
    }
}


interface Producer {
    void saleComputer(BigDecimal amount);

    void afterService(BigDecimal amount);
}

class SubProducer implements Producer {

    @Override
    public void saleComputer(BigDecimal amount) {
        System.out.println("卖出一台电脑,收款: " + amount + " 元");
    }

    @Override
    public void afterService(BigDecimal amount) {
        System.out.println("进行售后, 收款: " + amount + " 元");
    }
}

class ProxyInvocationHandler implements InvocationHandler {
    Producer producer;

    public ProxyInvocationHandler(Producer producer) {
        this.producer = producer;
    }

    /**
     * invocationHandler接口的内部实现类
     *
     * @param proxy  被代理对象
     * @param method 当前执行的方法
     * @param args   方法中的参数
     * @return 代理对象的实例
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        BigDecimal money = new BigDecimal(args[0].toString());
        if ("saleComputer".equals(method.getName())) {

            result = method.invoke(producer, money.multiply(new BigDecimal("3")));
        }
        return result;
    }
}





