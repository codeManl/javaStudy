package cn.liulele.structualpatterns.flyWeightPattern.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liulele
 * @description
 * @date 2022/9/6 19:43:43
 */
@Data
@AllArgsConstructor
public class Stock {
    private Integer total;

    private Integer used;
}
