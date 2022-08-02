package cn.liulele.creationalPatterns.builderPattern;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Box();
    }

}
