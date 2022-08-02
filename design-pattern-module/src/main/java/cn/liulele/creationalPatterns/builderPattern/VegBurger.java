package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;

/**
 * 蔬菜汉堡
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger...";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("33.21");
    }
}
