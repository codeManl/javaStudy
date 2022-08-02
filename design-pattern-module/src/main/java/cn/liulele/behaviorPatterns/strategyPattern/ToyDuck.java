package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description 玩具鸭 不会飞 不会叫
 * @date 2022-05-09 23:31:17
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        this.flyStrategy = new NoFlyStrategyImpl();
        this.quackStrategy = new NoQuackStrategyImpl();
    }

}
