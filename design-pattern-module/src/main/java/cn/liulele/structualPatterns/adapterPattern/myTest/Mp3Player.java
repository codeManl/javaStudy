package cn.liulele.structualPatterns.adapterPattern.myTest;

public class Mp3Player implements AudioPlayer {

    @Override
    public void playAudio(String name, String type) {
        System.out.println("当前播放的内容为: " + name + " ,文件格式为: " + type);
    }
}
