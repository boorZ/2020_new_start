package com.example.springdatajpademo.common.entity;

import com.example.springdatajpademo.common.jpa.Modifier;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Zhang Hong Zhi on 2018/6/20.
 */
@Setter
@Getter
public class Filter {
    private List<Condition> conditions;
    private List<OrderBy> orderBy;
    private Integer pageSize;
    private Integer pageIndex;

    public enum Direction {
        Asc, Desc
    }

    @Setter
    @Getter
    public static class OrderBy {
        private String path;
        private Direction order;
    }

    /**
     * 条件
     */
    @Setter
    @Getter
    public static class Condition {
        private List<Condition> set;
        private Modifier modifier;
        private String path;
        Object value;
    }
}
