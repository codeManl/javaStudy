package cn.liulele.structualpatterns.adapterPattern.example;

import lombok.Data;

import java.util.Date;

/**
 * @author liulele
 * @description
 * @date 2022/8/17 20:14:14
 */
@Data
public class TaobaoOrder {
    // 淘宝用户id
    private String tid;
    // 淘宝收货地址
    private String taddress;
    // 淘宝订单
    private String torderId;
    // 下单时间
    private Date orderDate;
    // 商品描述
    private String desc;

    private String sku;

}
