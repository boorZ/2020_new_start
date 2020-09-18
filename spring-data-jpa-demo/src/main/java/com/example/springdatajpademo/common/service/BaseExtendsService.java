package com.example.springdatajpademo.common.service;

import com.example.springdatajpademo.common.entity.PageFilter;
import com.example.springdatajpademo.common.entity.ResultPage;
import com.example.springdatajpademo.common.entity.business.DeleteEntity;
import com.example.springdatajpademo.common.repository.BaseRepository;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * @author 周林
 * @Description 通用服务
 * @email prometheus@noask-ai.com
 * @date 2020/9/10 17:22
 */
public interface BaseExtendsService<T extends DeleteEntity, PK extends Object, F extends PageFilter, VO> {
    BaseRepository<T, PK> getRepository();

    default T get(PK id) {
        return getRepository().getOne(id);
    }

    default ResultPage<VO> findAllByPage(F filter) {
        List<T> all = this.getRepository().findAll(buildQuery(filter));
        return null;
    }

    Specification<T> buildQuery(F filter);
}
