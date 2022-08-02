package cn.liulele.structualPatterns.proxyPattern;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-04-07 11:02:56
 */
public class ProxyPatternTest {
    public static void main(String[] args) {
        String fileName = "name1";
        Image image = new ProxyImage(fileName);
        image.display();

        image.display();
    }
}
