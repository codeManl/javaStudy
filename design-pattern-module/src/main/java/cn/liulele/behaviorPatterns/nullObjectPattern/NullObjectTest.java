package cn.liulele.behaviorPatterns.nullObjectPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-07 20:45:49
 */
public class NullObjectTest {
    public static void main(String[] args) {
        Book b1 = BookFactory.getBook(null);
        System.out.println(b1.getName());
    }
}
