package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-09 23:37:00
 */
public class NoQuackStrategyImpl implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("不会叫...");
    }
}
