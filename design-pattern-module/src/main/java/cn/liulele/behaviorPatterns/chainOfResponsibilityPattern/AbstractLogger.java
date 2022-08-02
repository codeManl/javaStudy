package cn.liulele.behaviorPatterns.chainOfResponsibilityPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-12 16:56:03
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    private AbstractLogger nextLogger;

    public void logMessage(int level, String message) {
        if (this.level >= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    abstract protected void write(String message);

}
