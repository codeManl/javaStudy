package cn.liulele.structualPatterns.decoratorPattern;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
