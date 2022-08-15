package cn.liulele.structualpatterns.facadePattern;

public interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw Circle...");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw Rectangle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}