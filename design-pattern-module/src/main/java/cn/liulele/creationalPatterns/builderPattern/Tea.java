package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;

public class Tea extends Drink {
    @Override
    public String name() {

        return "Tea...";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("103.2");
    }
}
