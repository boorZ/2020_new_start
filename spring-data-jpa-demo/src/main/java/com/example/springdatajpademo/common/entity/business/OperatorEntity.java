package com.example.springdatajpademo.common.entity.business;

import com.example.springdatajpademo.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 周林
 * @Description 操作人
 * @email prometheus@noask-ai.com
 * @date 2020/9/10 17:54
 */
@MappedSuperclass
@Setter
@Getter
public class OperatorEntity extends BaseEntity {
    /** 创建人 **/
    @Column(name = "create_user")
    private Integer createBy;

    /** 创建人 **/
    @Column(name = "modify_user")
    private Integer updateBy;

    /** 创建时间 **/
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    /** 更新时间 **/
    @Column(name = "modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    /**
     * 持久化之前自动填充实体属性
     **/
    @PrePersist
    protected void onCreate() {
        createAt = updateAt = new Date();
    }

    /**
     * 更新实体时更新修改时间
     **/
    @PreUpdate
    protected void onUpdate() {
        updateAt = new Date();
    }

}
