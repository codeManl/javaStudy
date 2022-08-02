package cn.liulele.behaviorPatterns.strategyPattern;

/**
 * @author 刘乐乐
 * @description 北京鸭 基本不会飞,叫声音好听
 * @date 2022-05-09 23:31:17
 */
public class BeijingDuck extends Duck {

    public BeijingDuck() {
        this.flyStrategy = new BadFlyStrategyImpl();
        this.quackStrategy = new GoodQuackStrategyImpl();
    }


}
