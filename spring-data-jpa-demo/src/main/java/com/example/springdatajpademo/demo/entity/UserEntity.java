package com.example.springdatajpademo.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 周林
 * @Description t_user表实体类
 * @email prometheus@noask-ai.com
 * @date 2020/8/18 17:07
 */

@Data
@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

}