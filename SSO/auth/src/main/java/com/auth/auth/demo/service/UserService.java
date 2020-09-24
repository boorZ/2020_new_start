package com.auth.auth.demo.service;

import com.auth.auth.demo.entity.User;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 10:51
 */
public interface UserService {
    User findUserById(String id);
    User findByUsername(User user);
}
