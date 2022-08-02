package cn.liulele.structualPatterns.decoratorPattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        System.out.println("------------------------");
        RedBorderDecorator redBorderDecorator = new RedBorderDecorator(circle);
        redBorderDecorator.draw();
    }
}
