package cn.liulele.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 23:14:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexTest {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Test
    public void createIndex() {
        System.out.println("--------");
    }

    @Test
    public void deleteIndex() {
    }

}
