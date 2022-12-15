package cn.liulele.utils;

import cn.liulele.entity.GAV;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class GenPom {
    private static final String outputPath = "E:\\path.txt";
    private static final String mavenProPath = "E:\\maven_repository";
    private static final String libPath = "C:\\Users\\KAYAK\\Desktop\\lib";

    public static List<GAV> generate() throws IOException {
        //将本地坐标读取到文件中,此过程第一次运行较慢
        readMaven();
        //读取需要匹配的jar
        Map<String, String> map = readLib();
        //读取上方写入的地址信息
        List<String> collect = new BufferedReader(new FileReader(new File(outputPath))).lines().collect(Collectors.toList());
        List<String> paths = getGenPaths(map, collect);
        System.out.println(map.size());
        System.out.println(paths.size());
        //genDependency(paths);
        return getGAV(paths);
    }

    /**
     * 获取需要生成的pom文件地址
     *
     * @param map
     * @param collect
     * @return
     */
    private static List<String> getGenPaths(Map<String, String> map, List<String> collect) {
        List<String> result = new ArrayList<>();
        //遍历所有需要匹配的文件
        map.forEach((key, value) -> {
            //遍历地址
            for (String path : collect) {
                //匹配规则 因为有些lib存在parent所有此处用于忽略parent,并且查找当前map 坐标名
                if (path.contains(key) && !path.contains("parent")) {
                    //如果匹配上则匹配版本
                    if (path.contains(value)) {
                        //替换jar文件为pom文件
                        result.add(path.replace("jar", "pom"));
                        return;
                    }
                }
            }
            //打印未匹配地址
            System.out.println("未匹配到:" + key + value);
        });
        return result;
    }

    /**
     * 生成坐标依赖,使用了Jsoup去分析pom文件
     *
     * @param paths
     * @throws FileNotFoundException
     */
    private static void genDependency(List<String> paths) throws FileNotFoundException {
        ArrayList<String> errorPaths = new ArrayList<>();
        //将匹配的结果生成坐标
        for (String path : paths) {
            File file = new File(path);
            String content = new BufferedReader(new FileReader(file)).lines().collect(Collectors.joining("\r\n"));
            Document parse = Jsoup.parse(content);
            Elements project = parse.getElementsByTag("project");

            String groupId = null;
            String artifactId = null;
            String version = null;
            Elements elements = project.get(0).children();
            for (Element child : elements) {
                if ("groupid".equals(child.tagName())) {
                    groupId = child.text();
                }
                if ("artifactid".equals(child.tagName())) {
                    artifactId = child.text();
                }
                if ("version".equals(child.tagName())) {
                    version = child.text();
                }
            }

            if (Objects.isNull(groupId) || Objects.isNull(artifactId) || Objects.isNull(version)) {
                errorPaths.add(path);
                continue;
            }

            String data = ("        <dependency>\n" +
                    "            <groupId>" + groupId + "</groupId>\n" +
                    "            <artifactId>" + artifactId + "</artifactId>\n" +
                    "            <version>" + version + "</version>\n" +
                    "        </dependency>");
            System.out.println(data);
        }

        errorPaths.forEach(System.out::println);
    }

    /**
     * 读取lib路劲 结果是 名,版本 如 spring-context-5.1.jar 结果为 spring-context=>5.1
     */
    private static Map<String, String> readLib() throws IOException {
        Map<String, String> map = new HashMap<>();
        File directory = new File(libPath);
        if (!directory.isDirectory()) {
            throw new RuntimeException("lib path must directory");
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            int index = file.getName().lastIndexOf("-");
            String artifactId = file.getName().substring(0, index);
            String version = file.getName().substring(index);
            map.put(artifactId, version);
        }
        return map;
    }

    /**
     * 读取本地maven坐标,将所有jar pom 文件地址写入到 outputPath 中 结果: f:/maven_repo/org/spring/context/5.1/org-spring-context-5.1.jar
     *
     * @throws IOException
     */
    private static void readMaven() throws IOException {
        List<File> read = read(new File(mavenProPath));
        File file = new File(outputPath);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        for (File x : read) {
            String path = x.getPath().concat("\r\n");
            outputStream.write(path.getBytes());
        }
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 递归读取所有文件
     *
     * @param file
     * @return
     */
    private static List<File> read(File file) {
        List<File> result = new ArrayList<>();
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File s : list) {
                List<File> temp = read(s);
                if (temp != null) {
                    result.addAll(temp);
                }
            }
            return result;
        }
        return Collections.singletonList(file);
    }

    private static List<GAV> getGAV(List<String> paths) {

        List<GAV> res = new ArrayList<>();

        paths.forEach(path -> {
            //E:\maven_repository\org\aspectj\aspectjrt\1.9.7\aspectjrt-1.9.7.pom
            String p = path.substring("E:\\maven_repository\\".length());
            // org\aspectj\aspectjrt\1.9.7\aspectjrt-1.9.7.pom
            String[] split = p.split("\\\\");
            String groupId = "";
            String artifactId = null;
            String version = null;
            String jarName = null;
            for (int i = 0; i < split.length; i++) {

                if (i <= split.length - 4) {
                    groupId += split[i];
                    groupId += ".";
                }
                if (i == split.length - 3) {
                    artifactId = split[i];
                }
                if (i == split.length - 2) {
                    version = split[i];
                }
                if (i == split.length - 1) {
                    jarName = split[i].substring(0, split[i].length() - 4) + ".jar";
                }
            }
            // org.aspectj.aspectjrt
            groupId = groupId.substring(0, groupId.length() - 1);

            String data = ("        <dependency>\n" +
                    "            <groupId>" + groupId + "</groupId>\n" +
                    "            <artifactId>" + artifactId + "</artifactId>\n" +
                    "            <version>" + version + "</version>\n" +
                    "        </dependency>");
            System.out.println(data);
            res.add(new GAV(jarName, data));
        });
        return res;
    }
}
