package lambda;

import java.util.HashMap;

public class LambdaStudy {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aa","aB");
        map.put("AA","CD");
        System.out.println(map.get("aa"));
        System.out.println(map.get("AA"));

    }
}
