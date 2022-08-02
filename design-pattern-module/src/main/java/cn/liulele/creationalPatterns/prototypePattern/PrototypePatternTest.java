package cn.liulele.creationalPatterns.prototypePattern;

public class PrototypePatternTest {
    public static void main(String[] args)  {
        Shape circle = ShapeCache.getShape("circle");
        circle.draw();
        ShapeCache.getShape("rectrangle").draw();

    }
}
