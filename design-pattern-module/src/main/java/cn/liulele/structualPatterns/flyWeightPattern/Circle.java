package cn.liulele.structualPatterns.flyWeightPattern;

/**
 * @author 刘乐乐
 * @description TODO
 * @date 2022/4/6-15:59
 */
public class Circle implements Shape {

    private Color color;
    private int x;
    private int y;
    private double radius;

    @Override
    public void draw() {
        System.out.println(this);
    }

    /**
     * @param color 外部状态，不会随着内部状态的变化而变化
     */
    public Circle(Color color) {
        this.color = color;
    }

    /**
     * @param x 内部状态
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y 内部状态
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param radius 内部状态
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
