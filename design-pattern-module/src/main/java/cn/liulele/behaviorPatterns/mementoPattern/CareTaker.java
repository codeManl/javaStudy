package cn.liulele.behaviorPatterns.mementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乐乐
 * @description CareTaker对象负责从Memento中恢复状态
 * @date 2022-04-18 16:41:56
 */
public class CareTaker {
    private final List<Memento> list = new ArrayList<>();

    public void add(Memento memento) {
        list.add(memento);
    }

    public Memento get(Integer index) {
        return list.get(index);
    }

}
