package cn.liulele.structualPatterns.adapterPattern;

public class AdaperPatternTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("素颜","mp3");
        audioPlayer.play("让子弹飞","mp4");
        audioPlayer.play("一出好戏","mp4");
        audioPlayer.play("以父之名","mp3");
    }
}
