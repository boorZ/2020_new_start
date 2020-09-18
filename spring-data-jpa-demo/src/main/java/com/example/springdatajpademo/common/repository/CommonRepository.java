package com.example.springdatajpademo.common.repository;

import com.example.springdatajpademo.common.entity.ResultPage;
import com.example.springdatajpademo.common.entity.business.DeleteEntity;

import java.util.List;

/**
 * @author 周林
 * @Description 通用Repository
 * @email prometheus@noask-ai.com
 * @date 2020/9/10 17:54
 */
public interface CommonRepository {

    void flush();

    <T> T get(Class<T> clazz, Integer id);

    //get(ErpUser.class, "userName = ? and id = ?", username, id)
    <T> T get(Class<T> clazz, String where, Object... parameters);

    <T> List<T> find(Class<T> clazz, String where, Object... parameters);

    <T> List<T> find(Class<T> clazz, Integer firstResult, Integer maxResults, String where, Object... parameters);

    <T> ResultPage<T> page(Class<T> clazz, Integer pageNumber, Integer pageSize, String where, Object... parameters);

    <T extends DeleteEntity> T save(T model, Integer operatorId);

    <T extends DeleteEntity> T update(T model, Integer operatorId);

    <T> long count(Class<T> clazz, String where, Object... parameters);

    <T> void delete(T entity);

    <T> T save(T model);

    <T> T update(T model);
}
