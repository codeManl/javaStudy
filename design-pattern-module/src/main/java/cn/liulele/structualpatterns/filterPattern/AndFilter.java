package cn.liulele.structualpatterns.filterPattern;

import java.util.List;

public class AndFilter implements PersonFilter {

    private PersonFilter firstFilter;
    private PersonFilter secondFilter;


    public AndFilter(PersonFilter firstFilter, PersonFilter secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public List<Person> filter(List<Person> personList) {
        List<Person> personList1 = firstFilter.filter(personList);
        return secondFilter.filter(personList1);
    }
}
