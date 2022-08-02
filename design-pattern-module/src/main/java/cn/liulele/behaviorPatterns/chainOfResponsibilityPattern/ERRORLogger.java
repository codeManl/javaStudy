package cn.liulele.behaviorPatterns.chainOfResponsibilityPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-12 17:07:59
 */
public class ERRORLogger extends AbstractLogger {
    public ERRORLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERRORLogger...   " + message);
    }
}
