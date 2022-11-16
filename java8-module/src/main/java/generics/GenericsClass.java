package generics;

/**
 * @author liulele
 * @description 泛型类 泛型不能为基本数据类型，但可以是它们的包装类
 * @date 2022/10/26 14:44:44
 */
public class GenericsClass<A,B,C,d> {

    private A a;
    private B b;
    private C c;
    private d d;

    public GenericsClass(A a, B b, C c, d d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public d getD() {
        return d;
    }

    public void setD(d d) {
        this.d = d;
    }
}

class GenericsClassForType<T> {

}

class GenericsClassForElement<E> {

}

class GenericsClassForMap<K,V> {

}
