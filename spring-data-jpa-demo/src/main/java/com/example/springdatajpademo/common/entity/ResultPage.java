package com.example.springdatajpademo.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/11 17:58
 */
@Setter
@Getter
public class ResultPage<T> implements Serializable {
    private Iterable<T> result;
    private int pageIndex;
    private int pageSize;
    private long total;

    public ResultPage() {
    }

    public ResultPage(Iterable<T> result, int pageIndex, int pageSize, long total) {
        this.result = result;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
    }
}
