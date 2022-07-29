import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流可以由数组和集合创建
 */
public class StreamCreate {
    /**
     * 使用集合创建stream流的方式
     * 1、通过list.stream()方法创建顺序流
     * 2、通过将list.parallelStream()方法创建并行流
     * 3、通过stream.parallel()方法可以将顺序流转为并行流
     */
    @Test
    public void createStream01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 6, 4);
        Stream<Integer> stream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();
        Stream<Integer> parallelStream2 = stream.parallel();
//        parallelStream2.filter(x-> x>3).forEach(System.out::println);
    }

    /**
     * 使用数组创建stream流的方式
     * 1、使用Arrays.stream()方法将数组转为stream流
     */
    @Test
    public void createStream02() {
        Integer[] integers = new Integer[]{3, 4, 6, 2};
        Stream<Integer> stream = Arrays.stream(integers);
    }

    /**
     * 使用Stream类的静态方法创建
     * 1、使用Stream.of()方法创建
     * 2、使用Stream.iterate()方法创建
     * 3、使用Stream.generate()方法创建
     *
     */
    @Test
    public void createStream03() {
        Stream<Integer> stream1 = Stream.of(1, 2, 5);
        stream1.forEach(System.out::println);
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(3);
        stream2.forEach(System.out::println);
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);
    }

}
