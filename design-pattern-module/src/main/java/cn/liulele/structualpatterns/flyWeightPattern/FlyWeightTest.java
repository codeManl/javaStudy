package cn.liulele.structualpatterns.flyWeightPattern;

/**
 * @author 刘乐乐
 * @description TODO
 * @date 2022-04-06 16:20:25
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle(Color.RED);
        redCircle.draw();

    }
}
