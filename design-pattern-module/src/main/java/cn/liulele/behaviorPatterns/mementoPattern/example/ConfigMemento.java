package cn.liulele.behaviorPatterns.mementoPattern.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liulele
 * @description 备忘录类
 * @date 2022/8/15 21:42:42
 */
@Data
@AllArgsConstructor
public class ConfigMemento {

    private ConfigFile configFile;

}
