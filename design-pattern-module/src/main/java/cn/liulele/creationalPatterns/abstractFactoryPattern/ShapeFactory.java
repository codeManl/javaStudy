package cn.liulele.creationalPatterns.abstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeName) {
        if ("circle".equals(shapeName)) {
            return new Circle();
        }
        if ("rectrangle".equals(shapeName)) {
            return new Rectrangle();
        }
        if ("square".equals(shapeName)) {
            return new Square();
        }
        throw new RuntimeException("未知的形状");
    }
}
