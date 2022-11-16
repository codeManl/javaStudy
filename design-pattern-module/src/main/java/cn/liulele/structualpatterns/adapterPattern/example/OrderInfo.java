package cn.liulele.structualpatterns.adapterPattern.example;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * @author liulele
 * @description
 * @date 2022/8/17 20:19:19
 */
@Data
public class OrderInfo {
    private String orderId;
    private String uid;
    private String address;
    private String sku;
    private Date date;

}
