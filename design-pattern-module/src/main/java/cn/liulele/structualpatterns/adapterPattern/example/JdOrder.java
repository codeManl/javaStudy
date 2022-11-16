package cn.liulele.structualpatterns.adapterPattern.example;

import lombok.Data;

import java.util.Date;

/**
 * @description 
 * @author liulele
 * @date 2022/8/17 20:14:14
 */
@Data
public class JdOrder {
    private String jId;
    private String jOrderId;
    private String sku;
    private String jAddr;
    private Date orderDate;
}
