package cn.liulele.behaviorPatterns.mementoPattern.example;

import lombok.Data;

/**
 * @author liuele
 * @description 记录者类 记录者类可以向备忘录中写入配置文件，同时可以拿出备忘录中的配置文件放到自身
 * @date 2022/8/15 21:43:43
 */
@Data
public class ConfigOriginator {
    private ConfigFile configFile;

    public ConfigMemento saveMemento() {
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento memento) {
        this.configFile = memento.getConfigFile();
    }
}
