package com.zl.springdataelasticsearchdemo.demo.dao;

import com.zl.springdataelasticsearchdemo.demo.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/5/26 17:25
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
}
