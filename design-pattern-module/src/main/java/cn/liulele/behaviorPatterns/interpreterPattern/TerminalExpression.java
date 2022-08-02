package cn.liulele.behaviorPatterns.interpreterPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-14 11:22:45
 */
public class TerminalExpression implements Expression {
    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }


    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
