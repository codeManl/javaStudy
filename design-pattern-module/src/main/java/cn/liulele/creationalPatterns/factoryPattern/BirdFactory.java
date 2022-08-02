package cn.liulele.creationalPatterns.factoryPattern;

/**
 * bird对象工厂，根据不同的名称返回不同的bird对象
 */
public class BirdFactory {
    public static Bird getBird(String birdName) {
        if ("b1".equals(birdName)) {
            return new BirdImpl1();
        }
        if ("b2".equals(birdName)) {
            return new BirdImpl2();
        }
        if ("b3".equals(birdName)) {
            return new BirdImpl3();
        }

        throw new RuntimeException("未知的鸟类");
    }
}
