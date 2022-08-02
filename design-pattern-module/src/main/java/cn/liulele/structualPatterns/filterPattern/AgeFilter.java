package cn.liulele.structualPatterns.filterPattern;

import java.util.List;
import java.util.stream.Collectors;

public class AgeFilter implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> personList) {
        // 过滤掉年龄小于11 的 ,返回的都是年龄大于11的
        return personList.stream().filter(x -> x.getAge() > 11).collect(Collectors.toList());

    }
}
