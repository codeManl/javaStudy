package cn.liulele.behaviorPatterns.mediatorPattern;

/**
 * @author 刘乐乐
 * @description 具体同事类
 * @date 2022-04-18 13:47:37
 */
public class ConcreteColleageue1 extends Colleague {

    public ConcreteColleageue1(Mediator mediator) {
        super(mediator);
    }

    @Override
    protected void update() {
        System.out.println("colleageue1 update...");
    }

    @Override
    protected void change() {
        System.out.println("colleageue1 change...");
        mediator.operat(this);

    }
}
