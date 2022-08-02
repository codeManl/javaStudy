package cn.liulele.creationalPatterns.builderPattern;

/**
 * 瓶装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
