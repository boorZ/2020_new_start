package com.example.springdatajpademo.common.service.impl;

import com.example.springdatajpademo.common.entity.ResultPage;
import com.example.springdatajpademo.common.entity.business.DeleteEntity;
import com.example.springdatajpademo.common.enums.IsEnum;
import com.example.springdatajpademo.common.repository.CommonRepository;
import com.example.springdatajpademo.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author 周林
 * @Description 通用服务实现类
 * @email prometheus@noask-ai.com
 * @date 2020/9/11 17:55
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private CommonRepository commonRepository;

    @Override
    public <T> T get(Class<T> clazz, Integer id) {
        return commonRepository.get(clazz, id);
    }

    @Override
    public <T> T get(Class<T> clazz, String where, Object... parameters) {
        return commonRepository.get(clazz, where, parameters);
    }

    @Override
    public <T> List<T> find(Class<T> clazz, String where, Object... parameters) {
        return commonRepository.find(clazz, where, parameters);
    }

    @Override
    public <T> List<T> find(Class<T> clazz, Integer limit, String where, Object... parameters) {
        return commonRepository.find(clazz, 0, limit, where, parameters);
    }

    @Override
    public <T> List<T> find(Class<T> clazz, Integer firstIndex, Integer limit, String where, Object... parameters) {
        return commonRepository.find(clazz, firstIndex, limit, where, parameters);
    }

    @Override
    public <T> ResultPage<T> page(Class<T> clazz, Integer pageNumber, Integer pageSize, String where, Object... parameters) {
        return commonRepository.page(clazz, pageNumber, pageSize, where, parameters);
    }

    @Override
    public <T> long count(Class<T> clazz, String where, Object... parameters) {
        return commonRepository.count(clazz, where, parameters);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> T save(T entity, Integer operatorId) {
        return commonRepository.save(entity, operatorId);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> T update(T entity, Integer operatorId) {
        return commonRepository.update(entity, operatorId);
    }


    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(T entity) {
        if (entity == null || IsEnum.NOT_IS.getCode().equals(entity.getDelete())) {
            return;
        }
        entity.setDelete(IsEnum.IS.getCode());
        commonRepository.update(entity);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(T entity, Integer operatorId) {
        if (entity == null || IsEnum.NOT_IS.getCode().equals(entity.getDelete())) {
            return;
        }
        entity.setDelete(IsEnum.IS.getCode());
        commonRepository.update(entity, operatorId);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(T entity, Consumer<T> handle) {
        if (entity == null || IsEnum.NOT_IS.getCode().equals(entity.getDelete())) {
            return;
        }
        handle.accept(entity);
        entity.setDelete(IsEnum.IS.getCode());
        commonRepository.update(entity);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(T entity, Integer operatorId, Consumer<T> handle) {
        if (entity == null || IsEnum.NOT_IS.getCode().equals(entity.getDelete())) {
            return;
        }
        handle.accept(entity);
        entity.setDelete(IsEnum.IS.getCode());
        commonRepository.update(entity, operatorId);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Integer operatorId) {
        if (id == null) {
            return;
        }
        this.delete(commonRepository.get(klass, id), operatorId);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(Class<T> klass, Integer id) {
        if (id == null) {
            return;
        }
        this.delete(commonRepository.get(klass, id));
    }


    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Integer operatorId, Consumer<T> handle) {
        if (id == null) {
            return;
        }
        this.delete(commonRepository.get(klass, id), operatorId, handle);
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void delete(Class<T> klass, Integer id, Consumer<T> handle) {
        if (id == null) {
            return;
        }
        this.delete(commonRepository.get(klass, id), handle);
    }

    @Override
    @Transactional
    public <T> void delete(T entity) {
        commonRepository.delete(entity);
    }


    @Override
    @Transactional
    public <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Integer operatorId) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        entities.forEach(id -> this.delete(klass, id, operatorId));
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        entities.forEach(id -> this.delete(klass, id));
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Integer operatorId, Consumer<T> handle) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        entities.forEach(id -> this.delete(klass, id, operatorId, handle));
    }

    @Override
    @Transactional
    public <T extends DeleteEntity> void batchDelete(Class<T> klass, List<Integer> entities, Consumer<T> handle) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        entities.forEach(id -> this.delete(klass, id, handle));
    }

    @Override
    @Transactional
    public <T> T save(T entity) {
        return commonRepository.save(entity);
    }

    @Override
    @Transactional
    public <T> T update(T entity) {
        return commonRepository.update(entity);
    }

    @Override
    public <T extends DeleteEntity> List<T> findAll(Class<T> klass) {
        return commonRepository.find(klass, "delState = ?", IsEnum.NOT_IS.getCode());
    }

    private <T extends DeleteEntity> T commonDelete(T entity, Consumer<T> handle) {
        T entityCommon = commonDelete(entity);
        if (entityCommon == null) {
            return null;
        }
        handle.accept(entity);
        return entityCommon;
    }

    private <T extends DeleteEntity> T commonDelete(T entity) {
        if (entity == null || IsEnum.NOT_IS.getCode().equals(entity.getDelete())) {
            return null;
        }
        entity.setDelete(IsEnum.IS.getCode());
        return entity;
    }
}
