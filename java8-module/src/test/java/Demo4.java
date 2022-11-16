import java.util.Arrays;

/**
 * @author liulele
 * @description
 * @date 2022/9/19 17:24:24
 */
public class Demo4 {
    public static void main(String[] args) {
        String str1 = "[1,2]";
        String str2 = "[1,]";
        String str3 = "[,2]";
        String str4 = "[,]";
        String[] arr1 = strToArr(str1);
        System.out.println(Arrays.toString(arr1));
        String[] arr2 = strToArr(str2);
        System.out.println(Arrays.toString(arr2));
        String[] arr3 = strToArr(str3);
        System.out.println(Arrays.toString(arr3));
        String[] arr4 = strToArr(str4);
        System.out.println(Arrays.toString(arr4));

    }

    private static String[] strToArr(String value) {

        // 去除"["   "]"
        String str = value.substring(1, (value.length() - 1));
        String[] split = str.split(",");

        // 处理 [,]
        if (split.length == 0) {
            // 如果数组的长度为0,则根据“,”出现的次数+1作为数组长度构建一个空数组
            String str2 = str.replace(",", "");
            String[] s = new String[str.length() - str2.length() + 1];
            Arrays.fill(s, "");
            return s;
        }
        // 处理[1,]
        if (str.endsWith(",")) {
            // 如果以,结尾,则在原数组的基础上加一位，值为“”
            String[] s = Arrays.copyOf(split, split.length + 1);
            s[s.length-1] = "";
            return s;
        }
        // [,1] [1,2] 直接split后符合预期,直接返回
        return split;






    }
}
