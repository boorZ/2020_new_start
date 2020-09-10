package com.zl.springdataelasticsearchdemo.demo.type.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/7/9 16:17
 */
@Data
public class ClassificationIndexDTO implements Serializable {
    /** 类型名称 */
    private String k;
    /** 类型值 */
    private String v;
    @Override
    public String toString() {
        return super.toString();
    }
}
