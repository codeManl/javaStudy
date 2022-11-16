package generics;

/**
 * @author liulele
 * @description 泛型接口的实现类，在实现接口时需要指定具体的类型
 * @date 2022/10/26 14:49:49
 */
public class GenericsInterfaceImpl implements GenericsInterface<String> {
    @Override
    public void show(String s) {

    }
}

class Impl2 implements GenericsInterface<Integer> {

    @Override
    public void show(Integer integer) {

    }
}

// class Impl3 implements GenericsInterface<int> {
//
//    @Override
//    public void show(int i) {
//
//    }
//}
