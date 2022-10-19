package cn.liulele.es.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author liuele
 * @description
 * @date 2022/9/17 23:10:10
 */
@Tag(name = "", description = "desc")
@RestController("/index")
public class IndexController {

    @Autowired
    private ElasticsearchClient client;

    @Operation(summary = "创建索引")
    @PutMapping("/{indexName}")
    public String createIndex(@PathVariable("indexName") String indexName) {

        System.out.println("indexName = " + indexName);
        System.out.println("555");
        try {
            CreateIndexResponse response = client.indices().create(builder -> builder.index(indexName));
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
