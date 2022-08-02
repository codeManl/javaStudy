package cn.liulele.creationalPatterns.prototypePattern;

public class Circle extends Shape {
    public Circle() {
        this.setType("Circle");
    }

    @Override
    void draw() {
        System.out.println("Circle draw...");
    }
}
