package cn.liulele.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 22:59:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product",shards = 3,replicas = 1)
public class Product {
    /**
     * 商品唯一标识
     */
    @Id
    private Long id;
    /**
     * 商品名称
     */
    @Field(type = FieldType.Text)
    private String title;
    /**
     * 商品分类
     */
    @Field(type = FieldType.Keyword)
    private String category;
    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * 商品图片的url
     */
    @Field(type = FieldType.Keyword,index = false)
    private String imagesUrl;
}
