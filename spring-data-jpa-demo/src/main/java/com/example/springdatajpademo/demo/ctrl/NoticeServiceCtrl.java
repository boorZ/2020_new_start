package com.example.springdatajpademo.demo.ctrl;


import com.example.springdatajpademo.demo.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "公告Demo", tags = "公告Demo")
@RequestMapping("/nsr/notice")
public class NoticeServiceCtrl {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ApiOperation(value = "demo", notes = "demo")
    public String demo() {
//        noticeService
        return "OK";
    }
}
