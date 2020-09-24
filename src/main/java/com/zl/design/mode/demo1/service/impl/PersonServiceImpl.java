package com.zl.design.mode.demo1.service.impl;

import com.zl.design.mode.demo1.reflex.PersonReflexContent;
import com.zl.design.mode.demo1.service.Person;
import com.zl.design.mode.demo1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/23 18:00
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonReflexContent personReflexContent;

    @Override
    public String speak(String type) {
        Person person = personReflexContent.getPerson(type);
        if (person == null) {
            return "你不是人";
        } else {
            return person.speak();
        }
    }
}
