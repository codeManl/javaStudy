package cn.liulele.structualPatterns.proxyPattern;


/**
 * @author 刘乐乐
 * @description 真实对象
 * @date 2022-04-07 10:50:57
 */
public class RealImage implements Image {
    private final String imageName;

    public RealImage(String name) {
        this.imageName = name;
        loadFormDisk(name);
    }

    private void loadFormDisk(String fileName) {
        System.out.println("load from disk, filename  = " + fileName);
    }

    @Override
    public void display() {
        System.out.println("display... imagename = " +   this.imageName);
    }
}
