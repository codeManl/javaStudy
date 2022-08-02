package cn.liulele.behaviorPatterns.nullObjectPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-07 20:49:32
 */
public class RealBook extends Book {

    public RealBook(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    boolean isNull() {
        return false;
    }
}
