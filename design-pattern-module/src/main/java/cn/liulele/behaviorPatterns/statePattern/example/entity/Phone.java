package cn.liulele.behaviorPatterns.statePattern.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liulele
 * @description
 * @date 2022/9/19 19:50:50
 */

@Data
@NoArgsConstructor
public class Phone {

    private String phoneNumber;

    private Machine machine;
}
