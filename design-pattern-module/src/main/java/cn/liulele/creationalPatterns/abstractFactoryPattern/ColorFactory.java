package cn.liulele.creationalPatterns.abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorName) {
        if ("red".equals(colorName)) {
            return new Red();
        }
        if ("green".equals(colorName)) {
            return new Green();
        }
        if ("blue".equals(colorName)) {
            return new Blue();
        }

        throw new RuntimeException("错误的颜色: " + colorName);
    }
}
