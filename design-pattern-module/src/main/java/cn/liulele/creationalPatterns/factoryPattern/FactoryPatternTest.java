package cn.liulele.creationalPatterns.factoryPattern;

/**
 * 简单工厂模式
 */
public class FactoryPatternTest {

    public static void main(String[] args) {
        Bird bird = BirdFactory.getBird("b1");
        bird.fly();
        Bird bird2 = BirdFactory.getBird("b2");
        bird2.fly();
        Bird bird3 = BirdFactory.getBird("b3");
        bird3.fly();

    }

}
