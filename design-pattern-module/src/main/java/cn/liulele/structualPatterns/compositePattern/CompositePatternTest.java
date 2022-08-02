package cn.liulele.structualPatterns.compositePattern;

public class CompositePatternTest {
    public static void main(String[] args) {
        Employee p1 = new Employee("zs", 11, Position.POSITION1);
        Employee p2 = new Employee("ls", 22, Position.POSITION2);
        Employee p3 = new Employee("ww", 33, Position.POSITION2);
        Employee p4 = new Employee("ml", 32, Position.POSITION3);

        p1.addSubordinate(p2);
        p1.addSubordinate(p3);
        p2.addSubordinate(p4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
