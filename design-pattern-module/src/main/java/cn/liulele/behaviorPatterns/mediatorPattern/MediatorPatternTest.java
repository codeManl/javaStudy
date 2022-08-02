package cn.liulele.behaviorPatterns.mediatorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-18 14:00:31
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague colleague1 = new ConcreteColleageue1(mediator);
        Colleague colleague2 = new ConcreteColleageue2(mediator);

        mediator.add(colleague1);
        mediator.add(colleague2);
        colleague1.change();
        System.out.println();
        colleague2.change();
    }
}
