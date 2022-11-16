package cn.liulele.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 17:05:05
 */
@Configuration
@MapperScan("cn.liulele.mapper")
public class MyBatisConfig {
}
