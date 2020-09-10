package com.zl.springdataelasticsearchdemo.demo.type.dto;

import java.io.Serializable;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2019/10/16
 */
public class LabelDTO implements Serializable {
    private Long labelId;
    private String labelName;
    private Long labelTypeId;
    private String labelTypeName;
    private Long orderBy;
    private Long typeOrderBy;

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public Long getTypeOrderBy() {
        return typeOrderBy;
    }

    public void setTypeOrderBy(Long typeOrderBy) {
        this.typeOrderBy = typeOrderBy;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Long getLabelTypeId() {
        return labelTypeId;
    }

    public void setLabelTypeId(Long labelTypeId) {
        this.labelTypeId = labelTypeId;
    }

    public String getLabelTypeName() {
        return labelTypeName;
    }

    public void setLabelTypeName(String labelTypeName) {
        this.labelTypeName = labelTypeName;
    }
}
