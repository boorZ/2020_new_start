package com.zl.springdataelasticsearchdemo.demo.dao;

import com.zl.springdataelasticsearchdemo.demo.entity.SeIndexBo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/5/26 17:25
 */
public interface SeIndexRepository extends ElasticsearchRepository<SeIndexBo, Long> {
}
