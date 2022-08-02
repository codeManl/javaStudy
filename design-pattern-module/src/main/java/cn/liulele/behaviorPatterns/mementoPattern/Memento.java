package cn.liulele.behaviorPatterns.mementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乐乐
 * @description 备忘录，用来存放某个时刻的状态
 * @date 2022-04-18 16:32:13
 */
public class Memento {

    private final String status;

    public Memento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
