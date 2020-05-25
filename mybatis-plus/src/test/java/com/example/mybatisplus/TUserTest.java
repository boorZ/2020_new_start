package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.demo.entities.TUser;
import com.example.mybatisplus.demo.mappers.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TUserTest {
    @Autowired
    private TUserMapper userMapper;

    @Test
    public void queryTUserForPage() {
        IPage<TUser> userPage = new Page<>(1, 2);//参数一是当前页，参数二是每页个数
        userPage = userMapper.selectPage(userPage, null);
        List<TUser> list = userPage.getRecords();
        for (TUser user : list) {
            System.out.println(user);
        }
    }
}
