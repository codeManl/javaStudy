package cn.liulele.structualPatterns.facadePattern;

public class FacedePatternTest {
    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawCircle();
        facade.drawRectangle();
        facade.drawSquare();
    }
}
