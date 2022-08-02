package cn.liulele.behaviorPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乐乐
 * @description 目标对象类，提供观察者注册和退订方法。 当目标状态发生变化时，通知所有注册的观察者
 * @date 2022-04-19 15:43:17
 */
public  class Subject {
    private final List<Observer> observers = new ArrayList<>();

    // 注册
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 退订
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // 通知所有观察者
    protected void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }



}
