package cn.liulele.behaviorPatterns.interpreterPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-14 10:58:32
 */
public class InterpreterPatternTest {
    public static void main(String[] args) {

        Expression isMale = getMaleExpression();
        System.out.println(isMale.interpret("admin is a male"));
        System.out.println(isMale.interpret("admin2"));

        Expression isFemale = getFemaleExpression();
        System.out.println(isFemale.interpret("admin is a female"));
        System.out.println(isFemale.interpret("admin2"));
    }

    private static Expression getMaleExpression() {
        Expression expression1 = new TerminalExpression("admin");
        Expression expression2 = new TerminalExpression("male");

        return new AndExpression(expression1, expression2);
    }

    private static Expression getFemaleExpression() {
        Expression expression1 = new TerminalExpression("admin2");
        Expression expression2 = new TerminalExpression("female");

        return new OrExpression(expression1, expression2);
    }
}
