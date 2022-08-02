package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger...";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("55.4");
    }
}
