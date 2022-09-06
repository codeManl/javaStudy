package cn.liulele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuele
 * @description 配置获取服务
 * @date 2022/8/16 21:52:52
 */
@Configuration
@EnableConfigurationProperties(StarterServiceProperties.class)
@ConditionalOnClass(StarterService.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    StarterService starterService() {
        return new StarterService(properties.getUserStr());
    }
}
