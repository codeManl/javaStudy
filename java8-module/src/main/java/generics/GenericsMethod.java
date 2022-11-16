package generics;

/**
 * @author liulele
 * @description 泛型用在method上
 * @date 2022/10/26 14:53:53
 */
public class GenericsMethod {

    public <T> T get(T t) {
        return t;
    }
}

class M2<E> {

    public <T> E get(T t) {
        return (E) t;
    }
}
