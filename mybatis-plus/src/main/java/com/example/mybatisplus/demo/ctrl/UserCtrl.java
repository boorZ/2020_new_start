package com.example.mybatisplus.demo.ctrl;

import com.example.mybatisplus.common.utils.PageResultDTO;
import com.example.mybatisplus.demo.entities.TUser;
import com.example.mybatisplus.demo.mappers.TUserMapper;
import com.example.mybatisplus.demo.service.UserService;
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

    @Autowired
    private TUserMapper TUserMapper;

    @GetMapping("/findById")
    @ApiOperation(value = "findById", notes = "findById")
    public TUser findById(@RequestParam(value = "id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value = "page", notes = "page")
    public PageResultDTO<TUser> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userService.page(pageIndex, pageSize);
    }
}
