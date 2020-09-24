package com.auth.auth.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;
    String username;
    String password;

//    public String getToken(User user) {
//        String token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
//        return token;
//    }
}