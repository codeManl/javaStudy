package cn.liulele.behaviorPatterns.commandPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-13 14:33:31
 */
public class CommandPatternTest {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Order buyOrder = new BuyOrder(stock);
        Order sellOrder = new SellOrder(stock);

        Broker broker = new Broker();
        broker.addOrder(buyOrder);
        broker.addOrder(sellOrder);

        broker.take();

    }
}
