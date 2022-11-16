package cn.liulele.structualpatterns.flyWeightPattern.example;

import lombok.Data;

import java.util.Date;

/**
 * @author liulele
 * @description
 * @date 2022/9/6 19:41:41
 */
@Data
public class Activity {

    private Long id;        // 活动ID
    private String name;    // 活动名称
    private String desc;    // 活动描述
    private Date startTime; // 开始时间
    private Date stopTime;  // 结束时间
    private Stock stock;    // 活动库存
}
