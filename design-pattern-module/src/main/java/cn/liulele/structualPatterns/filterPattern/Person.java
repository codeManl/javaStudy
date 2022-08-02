package cn.liulele.structualPatterns.filterPattern;

public class Person {

    private String name;
    private String gender;
    private boolean isSingle;
    private int age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", isSingle=" + isSingle +
                ", age=" + age +
                '}';
    }

    public Person(String name, String gender, boolean isSingle, int age) {
        this.name = name;
        this.gender = gender;
        this.isSingle = isSingle;
        this.age = age;
    }
}
