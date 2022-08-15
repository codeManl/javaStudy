package cn.liulele.structualpatterns.filterPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zs", "MALE", true, 12));
        list.add(new Person("ls", "FEMALE", false, 11));
        list.add(new Person("ww", "FEMALE", true, 15));
        list.add(new Person("ml", "MALE", false, 10));
        list.add(new Person("tq", "FEMALE", true, 22));

        MaleFilter maleFilter = new MaleFilter();
        List<Person> person = maleFilter.filter(list);
        System.out.println(person);

        FemaleFilter femaleFilter = new FemaleFilter();
        List<Person> person1 = femaleFilter.filter(list);
        System.out.println(person1);


        PersonFilter ageFilter = new AgeFilter();
        List<Person> person2 = ageFilter.filter(list);
        System.out.println(person2);

        PersonFilter andFilter = new AndFilter(maleFilter, ageFilter);
        List<Person> person3 = andFilter.filter(list);
        System.out.println(person3);

        PersonFilter orFilter = new OrFilter(femaleFilter,ageFilter);
        List<Person> person4 = orFilter.filter(list);
        System.out.println(person4);
    }
}
