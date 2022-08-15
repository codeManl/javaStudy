package cn.liulele.structualpatterns.bridgePattern;

public class Mp4File implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println(fileName + "格式为 mp4 , 解码完成");
    }
}
