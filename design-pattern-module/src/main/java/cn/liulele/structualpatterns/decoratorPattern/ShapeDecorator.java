package cn.liulele.structualpatterns.decoratorPattern;

public abstract class ShapeDecorator implements Shape {
    // 被包装的形状
    private Shape decoratedShape;

    public ShapeDecorator(Shape shape) {
        this.decoratedShape = shape;
    }


    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
