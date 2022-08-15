package cn.liulele.structualpatterns.adapterPattern;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void plyaVlc(String name) {
        System.out.println("vlc is playing , the name is " + name);
    }

    @Override
    public void playMp4(String name) {

    }
}
