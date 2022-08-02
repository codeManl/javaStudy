package cn.liulele.behaviorPatterns.commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乐乐
 * @description 命令调用类
 * @date 2022-04-13 14:30:37
 */
public class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    /**
     * 调用
     */
    public void take() {
        orderList.forEach(Order::execute);

        orderList.clear();
    }


}
