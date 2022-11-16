package cn.liulele.behaviorPatterns.statePattern.example.entity;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.entity.Phone;
import lombok.Data;

/**
 * @author liulele
 * @description
 * @date 2022/9/19 19:47:47
 */
@Data
public class User {
    private Integer uid;
    private String name;
    private Phone phone;
}
