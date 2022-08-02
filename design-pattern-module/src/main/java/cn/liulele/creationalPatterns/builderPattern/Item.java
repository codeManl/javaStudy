package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;

/**
 * 食物条目(汉堡和饮料)
 */
public interface Item {
    /**
     * 获取食物名称
     *
     */
    String name();

    /**
     * 获取食物包装方式
     */
    Packing packing();

    /**
     * 获取食物价格
     */
    BigDecimal price();
}
