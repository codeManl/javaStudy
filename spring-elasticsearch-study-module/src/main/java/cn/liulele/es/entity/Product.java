package cn.liulele.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 22:59:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * 商品唯一标识
     */
    private Long id;
    /**
     * 商品名称
     */
    private String title;
    /**
     * 商品分类
     */
    private String category;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品图片的url
     */
    private String imagesUrl;
}
