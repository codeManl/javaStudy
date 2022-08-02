package cn.liulele.creationalPatterns.builderPattern;

public class MealBuilder {
    /**
     * 套餐一
     */
    public Meal prepareMealOne() {

        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new VegBurger());
        meal.addItem(new Tea());
        return meal;
    }

    /**
     * 套餐二
     */
    public Meal prepareMealTwo() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Tea());
        meal.addItem(new Cola());
        return meal;
    }
}
