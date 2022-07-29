import entity.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUse {
    List<Person> personList = new ArrayList<Person>();

    @Before
    public void before() {
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
    }

    /**
     * stream流的遍历
     */
    @Test
    public void streamIteratorTest() {

        List<Integer> list = Arrays.asList(1, 5, 2, 6, 42, 26);
/*        System.out.println(list.stream().count());
        long count = list.stream().filter(x -> x > 3).count();
        System.out.println(count);*/
//        list.stream().forEach(System.out::println); // 遍历打印所有的list
//        list.stream().filter(x->x%3==0).forEach(System.out::println); // 筛选出对3取余等于0的，并打印
        /*Optional<Integer> any = list.stream().filter(x -> x > 5).findAny(); // findAny()一直筛选到大于5的为止
        Integer integer = any.get();
        System.out.println(integer);*/
//        System.out.println(list.parallelStream().filter(x -> x > 5).findAny().get()); // 同上
        /*boolean isMatch1 = list.stream().anyMatch(x -> x > 3); // 判断list中是否有数据大于3(只要有就行)
        System.out.println(isMatch1);*/
//        System.out.println(list.stream().allMatch(x -> x > 3)); // 判断list中的所有数据都大于3（全部数据都要满足才能为true）
//        System.out.println(list.stream().noneMatch(x -> x == 3)); //判断list中的所有数据都不等于3(全部数据都不满足条件才为true)

//        System.out.println(list.stream().filter(x -> x > 5).findFirst().get()); //findFirst() 匹配第一个

        List<String> collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
