package com.example.mybatisplus.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisplus.common.repository.CommonMapper;
import com.example.mybatisplus.common.utils.PageResultDTO;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>  entities
 * @param <PK> primry key
 * @param <F>  query condition
 * @author 周林
 * @Description Integration with generic Service
 * @email prometheus@noask-ai.com
 * @date 2020/4/8 10:52
 */
public interface CommonService<T, PK extends Serializable, F> {
    /**
     * 通用基础映射
     *
     * @return 通用基础映射
     */
    default CommonMapper<T> getMapper() {
        return getMapper();
    }
    /* basics */

//    Wrapper<T> buildQuery(F filter);

    PageResultDTO<T> page(Integer pageIndex, Integer pageSize);
//    /**
//     * 分页
//     *
//     * @param pageIndex    页码
//     * @param pageSize     每页显示数量
//     * @param orderItems      排序
//     * @param queryWrapper 实体对象封装操作类（可以为 null）
//     * @return
//     */
//    default PageResultDTO<T> page(Integer pageIndex, Integer pageSize, List<OrderItem> orderItems, Wrapper<T> queryWrapper) {
//        return this.getMapper().page(pageIndex, pageSize, orderItems, queryWrapper);
//    }

    /**
     * 查询所有
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return
     */
    default List<T> list(Wrapper<T> queryWrapper) {
        return this.getMapper().selectList(queryWrapper);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    default T findById(PK id) {
        return this.getMapper().selectById(id);
    }

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    default int save(T entity) {
        return this.getMapper().insert(entity);
    }

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    default int update(T entity) {
        return this.getMapper().updateById(entity);
    }

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity        实体对象 (set 条件值,可以为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    default int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> updateWrapper) {
        return this.getMapper().update(entity, updateWrapper);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    default int deleteById(PK id) {
        return this.getMapper().deleteById(id);
    }

    /**
     * 根据 entity 条件，删除记录
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     */
    default int delete(Wrapper<T> wrapper) {
        return this.getMapper().delete(wrapper);
    }
}
