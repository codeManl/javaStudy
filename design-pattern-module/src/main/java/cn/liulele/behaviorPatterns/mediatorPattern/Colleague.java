package cn.liulele.behaviorPatterns.mediatorPattern;

/**
 * @author 刘乐乐
 * @description 抽象同事类  包含一个中介成员
 * @date 2022-04-18 13:43:48
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 声明数据更新方法
     */
    protected abstract void update();

    /**
     * 声明数据修改方法
     */
    protected abstract void change();


}
