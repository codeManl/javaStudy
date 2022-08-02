package cn.liulele.structualPatterns.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 刘乐乐
 * @description 动态代理案例
 * @date 2022-04-07 11:21:12
 */
public class DynamicProxy2 {
    public static void main(String[] args) {

        Sell market = new Market();
        InvocationHandler microShop = new MicroShop(market);
        Sell proxyInstance = (Sell) Proxy.newProxyInstance(market.getClass().getClassLoader(), market.getClass().getInterfaces(), microShop);
        int money = proxyInstance.sellComputer(100);
        System.out.println("找微商买一台电脑,花费: "+money+" 元");
    }
}

interface Sell {
    int sellComputer(int money);
}

class Market implements Sell {
    @Override
    public int sellComputer(int money) {
        System.out.println("商场卖出一台电脑，收费: " + money + " 元");
        return money;
    }
}

class MicroShop implements InvocationHandler {

    private final Sell sell;

    public MicroShop(Sell sell) {
        this.sell = sell;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("微商开始去商场买货...");
        Object res = null;

        // 被代理对象执行sell()方法
        res = method.invoke(sell, args);

        int money = (int) res;
        res = money + 1000;
        // 后续增强处理
        System.out.println("微商返一个优惠券...");
        return res;
    }
}




