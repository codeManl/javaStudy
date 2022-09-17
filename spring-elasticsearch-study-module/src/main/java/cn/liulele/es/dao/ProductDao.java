package cn.liulele.es.dao;

import cn.liulele.es.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author liuele
 * @description
 * @date 2022/9/6 23:07:07
 */
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
