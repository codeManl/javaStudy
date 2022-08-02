package cn.liulele.behaviorPatterns.commandPattern;

/**
 * @author 刘乐乐
 * @description 请求类
 * @date 2022-04-13 14:21:53
 */
public class Stock {

    public void buy() {
        System.out.println("发出了  buy...的命令");
    }

    public void sell() {
        System.out.println("发出了  sell...的命令");
    }
}
