package cn.liulele.structualpatterns.proxyPattern;

/**
 * @author 刘乐乐
 * @description 代理对象
 * @date 2022-04-07 11:00:04
 */
public class ProxyImage implements Image {

    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
