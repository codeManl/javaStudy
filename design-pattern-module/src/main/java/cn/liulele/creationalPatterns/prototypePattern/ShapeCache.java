package cn.liulele.creationalPatterns.prototypePattern;

import java.util.Hashtable;

public class ShapeCache {
    private static final Hashtable<String, Shape> map;

    static {
        // 模拟数据库取出的数据
        map = new Hashtable<>();
        map.put("circle", new Circle());
        map.put("rectrangle", new Rectangle());
    }

    public static Shape getShape(String shapeName) {
        Shape cloneShape = null;
        try {
            Shape shape = map.get(shapeName);
            cloneShape = (Shape) shape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneShape;
    }
}
