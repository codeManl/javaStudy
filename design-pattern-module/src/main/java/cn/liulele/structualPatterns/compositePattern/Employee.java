package cn.liulele.structualPatterns.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int age;
    private Position position;
    // 下属员工
    private List<Employee> subordinate;

    public Employee(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
        subordinate = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void addSubordinate(Employee employee) {
        subordinate.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinate.remove(employee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", subordinate=" + subordinate +
                '}';
    }
}


enum Position {
    POSITION1, POSITION2, POSITION3
}