package cn.liulele.structualpatterns.bridgePattern;

public class BridgePatternTest {
    public static void main(String[] args) {
        VideoFile videoFile = new AviFile();
        OperatingSystem system = new WinSystem(videoFile);
        system.play("战狼2");
    }
}
