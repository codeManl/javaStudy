package cn.liulele.behaviorPatterns.nullObjectPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-07 20:47:36
 */
public class NullBook extends Book {

    public NullBook() {
    }

    @Override
    public String getName() {
        return "THE NAME IS NULL";
    }

    @Override
    boolean isNull() {
        return true;
    }
}
