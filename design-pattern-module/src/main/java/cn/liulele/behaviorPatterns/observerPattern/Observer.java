package cn.liulele.behaviorPatterns.observerPattern;

/**
 * @author 刘乐乐
 * @description 观察者接口，定义目标通知时对应更新的方法
 * @date 2022-04-19 14:47:26
 */
public interface Observer {

    void update(Subject subject);
}
