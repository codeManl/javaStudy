package cn.liulele.structualPatterns.flyWeightPattern;

import java.util.HashMap;

/**
 * @author 刘乐乐
 * @description 创建shape对象的工厂
 * @date 2022-04-06 16:14:28
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> CIRCLE_MAP = new HashMap<>();

    public static Shape getCircle(Color color) {
        String colorName = color.getColorName();
        if (CIRCLE_MAP.containsKey(colorName)) {
            return CIRCLE_MAP.get(colorName);
        } else {
            Circle circle = new Circle(color);
            circle.setX(3);
            circle.setY(4);
            circle.setRadius(5);
            CIRCLE_MAP.put(color.getColorName(), circle);
            return circle;
        }
    }
}
