package com.auth.auth.demo.service.impl;

import com.auth.auth.demo.entity.User;
import com.auth.auth.demo.service.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 10:59
 */
@Service
public class TokenServiceImpl implements TokenService {
    public String getToken(User user) {
        String token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
