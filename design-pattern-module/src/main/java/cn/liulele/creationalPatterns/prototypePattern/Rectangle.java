package cn.liulele.creationalPatterns.prototypePattern;

public class Rectangle extends Shape {
    public Rectangle() {
        this.setType("Rectangle");
    }

    @Override
    void draw() {
        System.out.println("Rectangle draw...");
    }
}
