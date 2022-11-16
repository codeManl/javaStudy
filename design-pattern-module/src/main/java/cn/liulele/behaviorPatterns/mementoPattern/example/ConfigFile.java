package cn.liulele.behaviorPatterns.mementoPattern.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author liulele
 * @description 配置文件
 * @date 2022/8/15 21:33:33
 */
@Data
@AllArgsConstructor
public class ConfigFile {
    /**
     * 版本号
     */
    private Long version;
    /**
     * 内容
     */
    private String content;

    /**
     * 时间
     */
    private Date date;

    /**
     * 操作人
     */
    private String operator;
}
