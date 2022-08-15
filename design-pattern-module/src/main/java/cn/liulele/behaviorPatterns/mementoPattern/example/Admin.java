package cn.liulele.behaviorPatterns.mementoPattern.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuele
 * @description 管理员类
 * @date 2022/8/15 21:47:47
 */
public class Admin {
    private Integer index = 0;
    /**
     * 备忘录类的list集合
     */
    private List<ConfigMemento> configMementoList = new ArrayList<>();
    /**
     * 备忘录类的map集合 key:配置文件的版本号 value: 备忘录
     */
    private Map<Long, ConfigMemento> configMementoMap = new ConcurrentHashMap<>();

    /**
     * 存放一个备忘录
     *
     * @param configMemento
     */
    public void append(ConfigMemento configMemento) {
        configMementoList.add(configMemento);

        configMementoMap.put(configMemento.getConfigFile().getVersion(), configMemento);
        ++index;
    }

    /**
     * 获取指定版本号的备忘录
     *
     * @param version
     * @return
     */
    public ConfigMemento get(Long version) {
        return configMementoMap.get(version);
    }

    /**
     * 撤销 获取上一个版本的备忘录
     *
     * @return
     */
    public ConfigMemento undo() {
        int i = --index;
        if (i <= 0) {
            return configMementoList.get(0);
        } else {
            return configMementoList.get(i);
        }
    }

    /**
     * 重做 redo
     * @return
     */
    public ConfigMemento redo() {
        int i = ++index;
        if (i > configMementoList.size()) {
            return configMementoList.get(configMementoList.size() - 1);
        }else {
            return configMementoList.get(i);
        }
    }
}
