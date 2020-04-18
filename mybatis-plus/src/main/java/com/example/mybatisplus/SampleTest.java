package com.example.mybatisplus;

import com.example.mybatisplus.entities.User;
import com.example.mybatisplus.mappers.UserMapper;
import com.example.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//        Integer pageIndex = 1;
//        Integer pageSize = 10;
//        String orderBy = "";
//        Wrapper<User> queryWrapper = null;
//        userService.page(pageIndex, pageSize, orderBy, queryWrapper);
        User byId = userService.findById(2);
        System.out.println(byId);
    }
}
