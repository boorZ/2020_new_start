package com.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@MapperScan({"com.example.mybatisplus.demo.mappers","com.example.mybatisplus.common.config.MybatisPlusConfig"})
@SpringBootApplication
@EnableSwagger2
@EnableCaching
@MapperScan("com.example.mybatisplus.demo.mappers")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
