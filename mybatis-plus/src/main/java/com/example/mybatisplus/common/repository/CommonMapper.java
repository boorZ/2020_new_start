package com.example.mybatisplus.common.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utils.PageResultDTO;

import java.util.List;

/**
 * @author 周林
 * @Description 通用基础映射
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 16:09
 */
public interface CommonMapper<T> extends BaseMapper<T> {
    /**
     * 分页
     *
     * @param pageIndex    页码
     * @param pageSize     每页显示数量
     * @param orderItems      排序
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return
     */
    default PageResultDTO<T> page(Integer pageIndex, Integer pageSize, List<OrderItem> orderItems, Wrapper<T> queryWrapper) {
        Page<T> page = new Page<>(pageIndex,pageSize);
        page.setOrders(orderItems);
        Page<T> pageResults = selectPage(page, queryWrapper);

        PageResultDTO<T> pageResult = new PageResultDTO<>();
        pageResult.setPageIndex(Math.toIntExact(pageResults.getCurrent()));
        pageResult.setPageSize(Math.toIntExact(pageResults.getSize()));
        pageResult.setTotal(Math.toIntExact(pageResults.getTotal()));
        pageResult.setTotalPage(Math.toIntExact(pageResults.getTotal()));
        pageResult.setResult(pageResults.getRecords());
        return pageResult;
    }
}
