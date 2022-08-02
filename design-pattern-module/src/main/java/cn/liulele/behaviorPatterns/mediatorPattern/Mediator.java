package cn.liulele.behaviorPatterns.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乐乐
 * @description 抽象中介者 定义了与同事类进行通信的方法
 * @date 2022-04-18 11:12:47
 */
public abstract class Mediator {

    protected List<Colleague> colleagues = new ArrayList<>();

    public void add(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }

    /**
     * 通知其他同事类修改的方法，在此方法中统一协调所有的同事类，避免各个同事类之间互相调用，降低耦合
     * @param colleague
     */
    public abstract void operat(Colleague colleague);

}
