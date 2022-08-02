package cn.liulele.creationalPatterns.builderPattern;

/**
 *  打包盒
 */
public class Box implements Packing{
    @Override
    public String pack() {
        return "Box";
    }
}
