package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-09 23:28:33
 */
public abstract class Duck {
    /**
     * 鸭子的飞行策略
     */
    protected FlyStrategy flyStrategy;

    /**
     * 鸭子的喊叫策略
     */
    protected QuackStrategy quackStrategy;


    public void fly() {
        flyStrategy.fly();
    }

    public void quack() {
        quackStrategy.quack();
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }
}
