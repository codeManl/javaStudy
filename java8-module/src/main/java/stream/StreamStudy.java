package stream;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "dd", "dfdsf", "fsdfsd");
        Stream<String> stream = list.stream();
        Optional<String> max = stream.max(Comparator.comparing(String::length));
        System.out.println(max.get());
    }
}
