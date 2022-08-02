package cn.liulele.behaviorPatterns.commandPattern;

/**
 * @author 刘乐乐
 * @description buy 命令
 * @date 2022-04-13 14:28:05
 */
public class BuyOrder implements Order{
    private final Stock stock;

    public BuyOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
        System.out.println("buy 命令执行了");
    }
}
