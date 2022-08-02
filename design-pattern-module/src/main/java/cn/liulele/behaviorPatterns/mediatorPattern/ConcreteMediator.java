package cn.liulele.behaviorPatterns.mediatorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-18 13:58:03
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void operat(Colleague colleague) {
        // 1 改变 通知2    2改变 通知1
        if (colleague instanceof ConcreteColleageue1) {
            colleagues.get(1).update();
        }
        if (colleague instanceof ConcreteColleageue2) {
            colleagues.get(0).update();
        }
    }
}
