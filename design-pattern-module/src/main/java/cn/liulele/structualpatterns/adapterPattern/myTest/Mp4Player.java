package cn.liulele.structualpatterns.adapterPattern.myTest;

public class Mp4Player implements VideoPlayer {
    private final AudioPlayer audioPlayer;

    public Mp4Player(AudioPlayer player) {
        this.audioPlayer = player;
    }

    @Override
    public void playVideo(String name, String type) {
        if ("mp3".equals(type)) {
            audioPlayer.playAudio(name, type);
        } else {
            System.out.println("当前播放的内容为: " + name + " ,文件格式为: " + type);
        }

    }
}
