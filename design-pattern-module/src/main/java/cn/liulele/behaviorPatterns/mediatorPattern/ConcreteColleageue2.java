package cn.liulele.behaviorPatterns.mediatorPattern;

/**
 * @author 刘乐乐
 * @description 具体同事类
 * @date 2022-04-18 13:47:37
 */
public class ConcreteColleageue2 extends Colleague {

    public ConcreteColleageue2(Mediator mediator) {
        super(mediator);
    }

    @Override
    protected void update() {
        System.out.println("colleageue2 update...");
    }

    @Override
    protected void change() {
        System.out.println("colleageue2 change...");
        mediator.operat(this);

    }
}
