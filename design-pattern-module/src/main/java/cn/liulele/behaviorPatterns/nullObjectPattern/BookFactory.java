package cn.liulele.behaviorPatterns.nullObjectPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-07 20:41:49
 */
public class BookFactory {

    public static Book getBook(String bookName) {
        if (bookName != null) {
            return new RealBook(bookName);
        } else {
            return new NullBook();
        }
    }
}
