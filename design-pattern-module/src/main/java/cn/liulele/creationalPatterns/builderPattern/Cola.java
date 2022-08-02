package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;

public class Cola extends Drink {
    @Override
    public String name() {

        return "Cola...";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("32.2");
    }
}
