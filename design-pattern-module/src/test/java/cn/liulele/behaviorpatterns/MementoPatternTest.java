package cn.liulele.behaviorpatterns;

import cn.liulele.behaviorPatterns.mementoPattern.example.Admin;
import cn.liulele.behaviorPatterns.mementoPattern.example.ConfigFile;
import cn.liulele.behaviorPatterns.mementoPattern.example.ConfigMemento;
import cn.liulele.behaviorPatterns.mementoPattern.example.ConfigOriginator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author liuele
 * @description
 * @date 2022/8/15 22:03:03
 */
@Slf4j
public class MementoPatternTest {
    ConfigOriginator configOriginator = new ConfigOriginator();
    Admin admin = new Admin();

    @Before
    public void init() {
        configOriginator.setConfigFile(new ConfigFile(0L, "内容0", new Date(), "操作员0"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile(1L, "内容1", new Date(), "操作员1"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile(2L, "内容2", new Date(), "操作员2"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile(3L, "内容3", new Date(), "操作员3"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile(4L, "内容4", new Date(), "操作员4"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile(5L, "内容5", new Date(), "操作员5"));
        admin.append(configOriginator.saveMemento());

    }


    @Test
    public void test() {
        log.info("初始值,当前配置文件为: " + configOriginator.getConfigFile().toString());

        configOriginator.getMemento(admin.undo());
        log.info("回滚1步,当前配置文件为: " + configOriginator.getConfigFile().toString());

        configOriginator.getMemento(admin.undo());
        log.info("回滚2步,当前配置文件为: " + configOriginator.getConfigFile().toString());

        configOriginator.getMemento(admin.redo());
        log.info("重做1步,当前配置文件为: " + configOriginator.getConfigFile().toString());

        configOriginator.getMemento(admin.get(3L));
        log.info("回到第3步，当前配置文件为: " + configOriginator.getConfigFile().toString());
    }
}
