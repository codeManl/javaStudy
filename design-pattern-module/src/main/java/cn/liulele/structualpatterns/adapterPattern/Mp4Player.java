package cn.liulele.structualpatterns.adapterPattern;

public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void plyaVlc(String name) {

    }

    @Override
    public void playMp4(String name) {
        System.out.println("mp4 is playing , the name is " + name);
    }
}
