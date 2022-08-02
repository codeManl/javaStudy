package cn.liulele.behaviorPatterns.mementoPattern;

/**
 * @author 刘乐乐
 * @description Originator 创建并在Memento中存储状态
 * @date 2022-04-18 16:38:54
 */
public class Originator {

    private String status;

    public Memento saveStatusToMemento() {
        return new Memento(status);
    }

    public void getStatusFromMemento(Memento memento) {
        status = memento.getStatus();
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
