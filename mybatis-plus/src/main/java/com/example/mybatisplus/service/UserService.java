package com.example.mybatisplus.service;

import com.example.mybatisplus.Filters.UserFilter;
import com.example.mybatisplus.entities.TUser;
import common.service.CommonService;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 16:11
 */
public interface UserService extends CommonService<TUser, Integer, UserFilter> {
}
