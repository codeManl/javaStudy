package cn.liulele.structualpatterns.filterPattern;

import java.util.List;

public interface PersonFilter {

    List<Person> filter(List<Person> personList);
}
