package com.example.springdatajpademo.common.service;

import com.example.springdatajpademo.common.entity.ResultPage;
import com.example.springdatajpademo.common.entity.business.DeleteEntity;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author 周林
 * @Description 通用服务
 * @email prometheus@noask-ai.com
 * @date 2020/9/10 17:22
 */
public interface BaseService {
    <T> T get(Class<T> clazz, Integer id);

    <T> T get(Class<T> clazz, String where, Object... parameters);

    <T extends DeleteEntity> List<T> findAll(Class<T> klass);

    <T> List<T> find(Class<T> clazz, String where, Object... parameters);

    /*
     *
     * @firstIndex 从0开始。
     * */
    <T> List<T> find(Class<T> clazz, Integer firstIndex, Integer limit, String where, Object... parameters);

    <T> List<T> find(Class<T> clazz, Integer limit, String where, Object... parameters);

    /*
     *
     * @pageNumber 从1开始  firstIndex = (pageNumber - 1) * pageSize。
     * */
    <T> ResultPage<T> page(Class<T> clazz, Integer pageNumber, Integer pageSize, String where, Object... parameters);

    <T> long count(Class<T> clazz, String where, Object... parameters);

    <T extends DeleteEntity> T save(T entity, Integer operatorId);

    <T extends DeleteEntity> T update(T entity, Integer operatorId);

    <T extends DeleteEntity> void delete(T entity, Integer operatorId);

    <T extends DeleteEntity> void delete(T entity);

    <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Integer operatorId);

    <T extends DeleteEntity> void delete(Class<T> klass, Integer id);

    <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Integer operatorId);

    <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities);

    <T extends DeleteEntity> void delete(T entity, Integer operatorId, Consumer<T> handle);

    <T extends DeleteEntity> void delete(T entity, Consumer<T> handle);

    <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Integer operatorId, Consumer<T> handle);

    <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Consumer<T> handle);

    <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Integer operatorId, Consumer<T> handle);

    <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Consumer<T> handle);


    <T> void delete(T entity);

    <T> T save(T entity);

    <T> T update(T entity);
}
