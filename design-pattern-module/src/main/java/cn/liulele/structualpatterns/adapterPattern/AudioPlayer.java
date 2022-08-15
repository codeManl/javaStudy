package cn.liulele.structualpatterns.adapterPattern;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String name, String type) {
        if ("mp3".equals(type)) {
            System.out.println("当前播放的内容为: " + name + " ,文件格式为: " + type);
        } else {
            MediaAdapter mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(name, type);
        }
    }
}
