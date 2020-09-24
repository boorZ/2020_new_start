package com.zl.design.mode.demo1.service.impl;

import com.zl.design.mode.demo1.service.Person;
import org.springframework.stereotype.Component;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/23 18:02
 */
@Component("man")
public class ManPerson implements Person {
    @Override
    public String speak() {
        return "man";
    }
}
