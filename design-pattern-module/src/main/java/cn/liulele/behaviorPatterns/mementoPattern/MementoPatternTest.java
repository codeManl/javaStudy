package cn.liulele.behaviorPatterns.mementoPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-18 16:56:11
 */
public class MementoPatternTest {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();
        originator.setStatus("status 1");
        originator.setStatus("status 2");
        Memento memento = originator.saveStatusToMemento();
        careTaker.add(memento);
        originator.setStatus("status 3");
        originator.setStatus("status 4");
        Memento memento1 = originator.saveStatusToMemento();
        careTaker.add(memento1);

        originator.setStatus("status 5");
        System.out.println("---");
        System.out.println("current status: "+originator.getStatus());
        System.out.println("first status:" + careTaker.get(0).getStatus());
        System.out.println("second status:" + careTaker.get(1).getStatus()
        );
    }
}
