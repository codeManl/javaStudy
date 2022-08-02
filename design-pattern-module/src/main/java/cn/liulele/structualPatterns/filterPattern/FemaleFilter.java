package cn.liulele.structualPatterns.filterPattern;

import java.util.ArrayList;
import java.util.List;

public class FemaleFilter implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> personList) {
        ArrayList<Person> result = new ArrayList<>();

        for (Person person : personList) {
            if ("FEMALE".equals(person.getGender())) {
                result.add(person);
            }
        }
        return result;
    }
}
