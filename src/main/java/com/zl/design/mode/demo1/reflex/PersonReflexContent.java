package com.zl.design.mode.demo1.reflex;

import com.zl.design.mode.demo1.service.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/9/23 18:19
 */
@Component
public class PersonReflexContent implements ApplicationContextAware, InitializingBean {
    private Map<String, Person> beanMap;
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        this.beanMap = map;
    }

    public Person getPerson(String beanName) {
        return this.beanMap.get(beanName);
    }
}
