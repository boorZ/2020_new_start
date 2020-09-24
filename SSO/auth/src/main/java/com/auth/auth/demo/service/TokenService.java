package com.auth.auth.demo.service;

import com.auth.auth.demo.entity.User;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 10:59
 */
public interface TokenService {
    String getToken(User user);
}
