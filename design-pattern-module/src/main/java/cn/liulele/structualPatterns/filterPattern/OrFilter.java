package cn.liulele.structualPatterns.filterPattern;

import java.util.List;

public class OrFilter implements PersonFilter {

    private final PersonFilter firstFilter;
    private final PersonFilter secondFilter;

    public OrFilter(PersonFilter firstFilter, PersonFilter secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public List<Person> filter(List<Person> personList) {
        List<Person> firstFiltered = firstFilter.filter(personList);
        List<Person> secondFiltered = secondFilter.filter(personList);

        for (Person person : firstFiltered) {
            if (!secondFiltered.contains(person)) {
                secondFiltered.add(person);
            }
        }
        return secondFiltered;
    }
}
