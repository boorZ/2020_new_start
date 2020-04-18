package com.example.mybatisplus.ctrl;

import com.example.mybatisplus.entities.User;
import com.example.mybatisplus.service.UserService;
import common.utils.PageResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/4/15 14:41
 */

@RestController
@Api(value = "Mybatis-Plus-Demo", tags = "Mybatis-Plus-Demo")
@RequestMapping("/mybatis/plus/demo")
public class UserCtrl {
    @Autowired
    private UserService userService;

    @GetMapping("/findById")
    @ApiOperation(value = "findById", notes = "findById")
    public User findById(@RequestParam(value = "id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value = "page", notes = "page")
    public PageResultDTO<User> page(@RequestParam(value = "pageIndex") Integer pageIndex, Integer pageSize) {
        return userService.page(pageIndex, pageSize, null, null);
    }
}
