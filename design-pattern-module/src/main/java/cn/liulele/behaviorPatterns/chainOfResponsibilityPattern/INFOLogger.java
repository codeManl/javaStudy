package cn.liulele.behaviorPatterns.chainOfResponsibilityPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-12 17:07:59
 */
public class INFOLogger extends AbstractLogger {
    public INFOLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFOLogger...   " + message);
    }
}
