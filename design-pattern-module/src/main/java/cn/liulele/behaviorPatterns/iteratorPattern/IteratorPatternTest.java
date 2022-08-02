package cn.liulele.behaviorPatterns.iteratorPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-15 16:46:44
 */
public class IteratorPatternTest {
    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        Iterator<String> iterator = container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
