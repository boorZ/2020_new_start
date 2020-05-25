package com.example.mybatisplus.demo.service.impl;

import com.example.mybatisplus.common.utils.PageResultDTO;
import com.example.mybatisplus.demo.entities.TUser;
import com.example.mybatisplus.demo.mappers.TUserMapper;
import com.example.mybatisplus.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/4/15 15:04
 */
@Service
public class UserServiceImpl implements UserService {
    private final TUserMapper userMapper;

    public UserServiceImpl(TUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageResultDTO<TUser> page(Integer pageIndex, Integer pageSize) {
//        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", filter.getName());
//        queryWrapper.like("name", filter.getName());
        return userMapper.page(pageIndex, pageSize, null, null);
    }
}
