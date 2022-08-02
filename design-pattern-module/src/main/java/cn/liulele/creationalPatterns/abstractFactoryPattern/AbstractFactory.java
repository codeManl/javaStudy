package cn.liulele.creationalPatterns.abstractFactoryPattern;

public abstract class AbstractFactory {

    public Color getColor(String colorName) {
        throw new RuntimeException("请选择具体的实现类");
    }

    public Shape getShape(String shapeName) {
        throw new RuntimeException("请选择具体的实现类");
    }
}
