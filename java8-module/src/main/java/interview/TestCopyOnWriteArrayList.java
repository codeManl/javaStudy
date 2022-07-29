package interview;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("aaa");
        String s = list.get(0);
        System.out.println(s);
    }
}
