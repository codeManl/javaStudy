package cn.liulele.creationalPatterns.builderPattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 */
public class Meal {
    private final List<Item> list = new ArrayList<>();

    void addItem(Item item) {
        list.add(item);
    }

    public BigDecimal getCost() {
        BigDecimal money = new BigDecimal("0");
        for (Item item : list) {
            money = money.add(item.price());
        }
        return money;
    }

    public void showItems() {
        for (Item item : list) {
            System.out.println(item.name() + "--" + item.packing() + "--" + item.price());
        }
    }
}
