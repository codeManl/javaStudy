package cn.liulele.creationalPatterns.builderPattern;


public class BuilderPatternTest {
    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();
        Meal mealOne = mealBuilder.prepareMealOne();
        System.out.println("mealOne...------------------");
        mealOne.showItems();
        System.out.println("cost: " + mealOne.getCost());

        Meal mealTwo = mealBuilder.prepareMealTwo();
        System.out.println("mealTwo...------------------");
        mealTwo.showItems();
        System.out.println("cost: " + mealTwo.getCost());
    }
}
