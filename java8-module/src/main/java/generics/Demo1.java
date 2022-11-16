package generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liulele
 * @description java 泛型的逆变和协变
 * 如果Cat是Animal的子类型，那么Cat[]也是Animal[]的子类型，我们称这种性质为协变,在Java中， 数组是协变的。
 * @date 2022/11/2 10:12:12
 */
public class Demo1 {
    public static void main(String[] args) {
/*        Cat cat1 = new Cat();
        Animal[] animals = new Cat[3];
        animals[0] = cat1;
        animals[1] = new Cat();
//        会抛出异常 java.lang.ArrayStoreException
//        animals[2] = new Dog();

        System.out.println(Arrays.toString(animals));*/

    /*    List list = new LinkedList();
        list.add(123);
        list.add("123");
        int  o = list.get(0);*/

/*        List<? extends Animal> animals = new LinkedList();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Animal());
        animals.add(new Object());

        Animal animal = animals.get(0);
        List<? super Animal> animals = new LinkedList();
        List<? super Animal> animals2 = new LinkedList();*/
    }
}

class Animal {

}

class Cat extends Animal {

}

class Dog extends Animal {

}