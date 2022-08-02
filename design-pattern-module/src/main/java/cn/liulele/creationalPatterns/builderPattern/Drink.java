package cn.liulele.creationalPatterns.builderPattern;



public abstract class Drink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

}
