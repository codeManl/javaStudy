package cn.liulele.structualPatterns.bridgePattern;

public class MacSystem extends OperatingSystem{
    public MacSystem(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Mac...");
        videoFile.decode(fileName);
    }
}
