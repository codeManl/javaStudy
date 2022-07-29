package enumStudy;

import java.util.Arrays;

/**
 *
 */
public class Enum01 {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        System.out.println(day.equals(Day.SUNDAY));
        System.out.println(day.compareTo(Day.SUNDAY));
        System.out.println(day.getDeclaringClass());
        System.out.println(day.name());
        System.out.println(day.ordinal());
        System.out.println(day.toString());
        System.out.println(Arrays.toString(Day.values()));
        Enum e = day;
        System.out.println(Arrays.toString(e.getDeclaringClass().getEnumConstants()));
    }
}

enum Day {
    /**
     * 周日
     */
    SUNDAY("周日", 0),
    /**
     * 周一
     */
    MONDAY("周一", 1);

    private Day(String name, Integer integer) {
        this.desc = name;
        this.num = integer;
    }

    /**
     * 描述
     */
    private String desc;
    /**
     * 一个int类型的值
     */
    private Integer num;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day);
            System.out.println(day.getNum());
            System.out.println(day.getDesc());
        }
    }
}
