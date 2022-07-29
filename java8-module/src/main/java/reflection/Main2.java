package reflection;


import entity.Person;
import util.DateFormatUtil;

import java.lang.reflect.InvocationTargetException;

public class Main2 {



    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Person person = new Person("zs", 3000, 22, "男", "地区1", "2021-10-10");
        person.setParentDate("2022-11-11");
        DateFormatUtil<Person> util = new DateFormatUtil<>();
        util.dateFormat(person);
        System.out.println(person);
        System.out.println(person.getParentDate());


    }

}
