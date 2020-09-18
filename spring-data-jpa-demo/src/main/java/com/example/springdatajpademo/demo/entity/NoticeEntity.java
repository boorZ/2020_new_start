package com.example.springdatajpademo.demo.entity;

import com.example.springdatajpademo.common.entity.business.DeleteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 周林
 * @Description t_notice表实体类
 * @email prometheus@noask-ai.com
 * @date 2020/8/18 17:07
 */

@Getter
@Setter
@Entity
@Table(name = "t_notice")
public class NoticeEntity extends DeleteEntity {

    @Column(name = "notice_name")
    private String noticeName;

    @Column(name = "notice_status")
    private String noticeStatus;

    @Column(name = "content")
    private String content;

    @Column(name = "publish_time")
    private Date publishTime;

    @Column(name = "rescind_status")
    private String rescindStatus;

    @Column(name = "lock_status")
    private Integer lockStatus;
}