package com.example.mybatisplus.demo.service;

import com.example.mybatisplus.demo.filters.UserFilter;
import com.example.mybatisplus.demo.entities.TUser;
import com.example.mybatisplus.common.service.CommonService;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 16:11
 */
public interface UserService extends CommonService<TUser, Integer, UserFilter> {
}
