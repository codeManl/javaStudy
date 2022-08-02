package cn.liulele.behaviorPatterns.observerPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-19 14:49:24
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject) subject;
        System.out.println("concreateObserver 2 .... " + concreteSubject.getSubjectState());
    }
}
