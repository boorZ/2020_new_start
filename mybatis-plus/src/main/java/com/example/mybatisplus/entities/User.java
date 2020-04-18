package com.example.mybatisplus.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 15:25
 */
@Getter
@Setter
@ToString
@Component
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
