package cn.liulele.structualpatterns.decoratorPattern;

public class RedBorderDecorator extends ShapeDecorator{

    public RedBorderDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("drawing red border");
    }
}
