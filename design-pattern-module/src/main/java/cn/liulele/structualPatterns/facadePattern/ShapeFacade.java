package cn.liulele.structualPatterns.facadePattern;

/**
 * @author 刘乐乐
 */
public class ShapeFacade {
    private final Shape rectangle = new Rectangle();
    private final Shape circle = new Circle();
    private final Shape square = new Square();

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

}
