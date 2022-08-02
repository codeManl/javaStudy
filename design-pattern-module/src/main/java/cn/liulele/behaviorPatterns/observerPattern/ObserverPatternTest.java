package cn.liulele.behaviorPatterns.observerPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-19 18:46:51
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();

        Observer observer = new ConcreteObserver();
        concreteSubject.attach(observer);
        Observer observer1 = new ConcreteObserver2();
        concreteSubject.attach(observer1);
        concreteSubject.setSubjectState("1");

    }
}
