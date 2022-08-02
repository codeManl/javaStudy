package cn.liulele.structualPatterns.flyWeightPattern;

/**
 * @author 刘乐乐
 * @description 颜色枚举类
 * @date 2022/4/6-16:02
 */
public enum Color {
    /**
     * 红色
     */
    RED("red"),
    /**
     * 蓝色
     */
    BLUE("blue"),
    /**
     * 绿色
     */
    GREEN("green");

    public String getColorName() {
        return colorName;
    }

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }
}
