package cn.liulele.creationalPatterns.abstractFactoryPattern;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("red...");
    }
}
