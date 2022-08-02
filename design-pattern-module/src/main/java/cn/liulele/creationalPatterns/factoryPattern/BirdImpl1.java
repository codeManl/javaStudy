package cn.liulele.creationalPatterns.factoryPattern;

/**
 * bird接口的实现类1
 */
public class BirdImpl1 implements Bird{
    @Override
    public void fly() {
        System.out.println("bird1 is fling");
    }
}
