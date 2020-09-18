package com.example.springdatajpademo.demo.repository;

import com.example.springdatajpademo.common.repository.BaseRepository;
import com.example.springdatajpademo.demo.entity.UserEntity;

/**
 * @author 周林
 * @Description t_user表资源库
 * @email prometheus@noask-ai.com
 * @date 2020/8/18 17:07
 */
public interface UserRepository extends BaseRepository<UserEntity, Long> {
}