package com.auth.auth.demo.service.impl;

import com.auth.auth.demo.entity.User;
import com.auth.auth.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 10:51
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String id) {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().filter(f -> f.getId().equals(id)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)) {
            log.info("用户不存在");
        }
        return collect.get(0);
    }

    @Override
    public User findByUsername(User user) {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().filter(f -> f.getUsername().equals(user.getUsername()) &&
                f.getPassword().equals(user.getPassword())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)) {
            log.info("用户不存在");
        }
        return collect.get(0);
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User("1", "z", "123456"));
        list.add(new User("2", "l", "123456"));
        return list;
    }
}
