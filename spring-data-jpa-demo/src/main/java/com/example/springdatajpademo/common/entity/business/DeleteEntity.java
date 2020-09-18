package com.example.springdatajpademo.common.entity.business;

import com.example.springdatajpademo.common.enums.IsEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 周林
 * @Description 删除状态
 * @email prometheus@noask-ai.com
 * @date 2020/9/10 17:48
 */
@MappedSuperclass
@Setter
@Getter
public class DeleteEntity extends OperatorEntity {
    /** 删除状态 **/
    @Column(name = "delete")
    @Temporal(TemporalType.TIMESTAMP)
    private String delete;
}
