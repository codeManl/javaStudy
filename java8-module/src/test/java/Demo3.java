/**
 * @author liulele
 * @description
 * @date 2022/9/19 17:24:24
 */
public class Demo3 {
    public static void main(String[] args) {
        String value = "[,,]";
        String value2 = "[1,2,3]";
        String[] split = value.split(",");
        String[] split1 = value2.split(",");
        System.out.println(split.length == split1.length);
    }
}
