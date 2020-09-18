package com.example.springdatajpademo.common.entity;

import java.io.Serializable;

/**
 * @author 周林
 * @Description t_notice表实体类
 * @email prometheus@noask-ai.com
 * @date 2020/8/18 17:07
 */
public class PageFilter implements Serializable {

    static final Integer DEFAULT_PAGE_INDEX = 1;
    static final Integer DEFAULT_PAGE_SIZE = 10;

    private Integer pageIndex;
    private Integer pageSize;

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageIndex() {
        this.pageIndex = (pageIndex == null || pageIndex < 1) ? DEFAULT_PAGE_INDEX : pageIndex;
        return pageIndex;
    }

    public Integer getPageSize() {
        this.pageSize = (pageSize == null || pageSize < 1) ? DEFAULT_PAGE_SIZE : pageSize;
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
