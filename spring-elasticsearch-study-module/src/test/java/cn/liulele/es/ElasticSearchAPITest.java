package cn.liulele.es;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuele
 * @description
 * @date 2022/9/17 22:36:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticSearchAPITest {

    @Autowired
    private ElasticsearchClient client;


    @Test
    public void testCreateIndex()throws  Exception {
        CreateIndexResponse resp = client.indices().create(builder -> builder.index("test02"));
        System.out.println(resp);
    }
}
