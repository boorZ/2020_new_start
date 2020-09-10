package com.example.springdatajpademo.ctrl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "测试Demo", tags = "测试Demo")
@RequestMapping("/nsr/calendar")
public class DemoCtrl {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ApiOperation(value = "demo", notes = "demo")
    public String demo() {
        return "OK";
    }
}
