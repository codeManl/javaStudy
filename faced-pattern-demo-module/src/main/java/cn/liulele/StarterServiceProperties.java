package cn.liulele;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description 
 * @author liuele
 * @date 2022/8/16 21:45:45
 */
@ConfigurationProperties("itstack.door")
@Data
public class StarterServiceProperties {

    private String userStr;


}
