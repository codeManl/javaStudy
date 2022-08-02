package cn.liulele.behaviorPatterns.interpreterPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-14 11:21:29
 */
public interface Expression {
    /**
     * 表达式对context  进行解析
     */
    boolean interpret(String context);
}
