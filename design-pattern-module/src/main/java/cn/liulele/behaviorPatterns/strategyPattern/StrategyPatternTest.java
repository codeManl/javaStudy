package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-09 23:39:04
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        Duck beijingDuck = new BeijingDuck();
        beijingDuck.fly();
        beijingDuck.quack();
        System.out.println("---------");

        Duck toyDuck = new ToyDuck();
        toyDuck.fly();
        toyDuck.quack();

        toyDuck.setFlyStrategy(new GoodFlyStrategyImpl());
        toyDuck.fly();
    }
}
