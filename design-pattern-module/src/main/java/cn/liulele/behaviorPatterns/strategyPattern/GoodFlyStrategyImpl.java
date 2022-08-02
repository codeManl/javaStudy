package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-09 23:34:02
 */
public class GoodFlyStrategyImpl implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("非常会飞...");
    }
}
