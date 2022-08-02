package cn.liulele.creationalPatterns.abstractFactoryPattern;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choise) {
        if ("shape".equals(choise)) {
            return new ShapeFactory();
        }
        if ("color".equals(choise)) {
            return new ColorFactory();
        }
        throw new RuntimeException("未知的工厂: " + choise);

    }
}
