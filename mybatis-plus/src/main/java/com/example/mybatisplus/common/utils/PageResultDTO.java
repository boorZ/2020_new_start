package com.example.mybatisplus.common.utils;

import java.util.List;

/**
 * @author 周林
 * @Description 通用分页对象
 * @email prometheus@noask-ai.com
 * @date 2019/8/30
 */
public class PageResultDTO<E> {
    private List<E> result;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalPage;
    private Integer total;

    public PageResultDTO() {
    }

    public PageResultDTO(List<E> result, Integer pageIndex, Integer pageSize, Integer totalPage, Long total) {
        this.result = result;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        if (total != null) {
            this.total = total.intValue();
        }
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
