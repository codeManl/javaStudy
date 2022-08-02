package cn.liulele.structualPatterns.bridgePattern;

public class WinSystem extends OperatingSystem {

    public WinSystem(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Win...");
        videoFile.decode(fileName);
    }
}
