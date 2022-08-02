package cn.liulele.behaviorPatterns.commandPattern;

/**
 * @author 刘乐乐
 * @description sell 命令
 * @date 2022-04-13 14:28:05
 */
public class SellOrder implements Order {
    private final Stock stock;

    public SellOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
        System.out.println("sell 命令执行了");
    }
}
