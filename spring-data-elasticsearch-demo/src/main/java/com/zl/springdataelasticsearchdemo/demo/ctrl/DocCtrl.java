package com.zl.springdataelasticsearchdemo.demo.ctrl;

import com.zl.springdataelasticsearchdemo.demo.dao.SeIndexRepository;
import com.zl.springdataelasticsearchdemo.demo.entity.SeIndexBo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/7/9 10:54
 */
@Log4j2
@RestController
@RequestMapping("/elastic")
public class DocCtrl {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private SeIndexRepository seIndexRepository;

    @GetMapping("/search")
    public Iterable<SeIndexBo> search() {
//
        return seIndexRepository.findAll();
    }
}
