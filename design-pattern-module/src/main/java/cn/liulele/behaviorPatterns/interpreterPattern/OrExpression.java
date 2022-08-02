package cn.liulele.behaviorPatterns.interpreterPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-15 16:09:14
 */
public class OrExpression implements Expression {

    private final Expression expression1;
    private final Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {

        return expression1.interpret(context) || expression2.interpret(context);
    }
}
