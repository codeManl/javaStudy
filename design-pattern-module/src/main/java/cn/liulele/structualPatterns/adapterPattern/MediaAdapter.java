package cn.liulele.structualPatterns.adapterPattern;

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if ("vlc".equals(type)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if ("mp4".equals(type)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String name, String type) {
        if ("vlc".equals(type)) {
            advancedMediaPlayer.plyaVlc(name);
        }
        if ("mp4".equals(type)) {
            advancedMediaPlayer.playMp4(name);
        }
    }
}
