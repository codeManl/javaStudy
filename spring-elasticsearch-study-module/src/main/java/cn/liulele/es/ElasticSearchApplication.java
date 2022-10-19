package cn.liulele.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class ElasticSearchApplication {
    public static void main(String[] args) {

        SpringApplication.run(ElasticSearchApplication.class, args);
    }
}
