package cn.liulele.behaviorPatterns.observerPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-19 18:41:08
 */
public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObserver();
    }

}
