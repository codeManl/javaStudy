package cn.liulele.structualpatterns.adapterPattern.myTest;

public class AdapterPatternTest {
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new Mp4Player(new Mp3Player());
        videoPlayer.playVideo("素颜","mp3");
        videoPlayer.playVideo("让子弹飞","mp4");
        videoPlayer.playVideo("一出好戏","mp4");
        videoPlayer.playVideo("以父之名","mp3");

    }
}
