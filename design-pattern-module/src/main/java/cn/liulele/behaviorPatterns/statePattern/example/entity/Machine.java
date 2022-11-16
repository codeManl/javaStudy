package cn.liulele.behaviorPatterns.statePattern.example.entity;

import lombok.Data;

/**
 * @author liulele
 * @description
 * @date 2022/9/19 19:50:50
 */
@Data
public class Machine {
    private String machineName;
    private boolean enable;

    public Machine(String machineName) {
        this.machineName = machineName;
        this.enable = true;
    }
}
