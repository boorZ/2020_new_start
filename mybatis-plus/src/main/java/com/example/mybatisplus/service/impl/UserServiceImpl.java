package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.Filters.Test;
import com.example.mybatisplus.Filters.UserFilter;
import com.example.mybatisplus.entities.TUser;
import com.example.mybatisplus.mappers.TUserMapper;
import com.example.mybatisplus.service.UserService;
import common.repository.CommonBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/4/15 15:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public CommonBaseMapper<TUser> getMapper() {
        return this.userMapper;
    }

    @Override
    public Wrapper<TUser> buildQuery(UserFilter filter) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", filter.getName());
        queryWrapper.like("name", filter.getName());
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 反射
        Test test = new Test();
        test.setAge(1);
        test.setName("a");
        test.setTestint(2);
        Class userFilterClass = test.getClass();
//        System.out.println(userFilterClass);
//        System.out.println(userFilterClass.getName());
//        // 获取所有构造方法
//        Constructor[] declaredConstructors = userFilterClass.getDeclaredConstructors();
////        System.out.println(Arrays.toString(declaredConstructors));
//        for (Constructor declaredConstructor : declaredConstructors) {
//            // 获取修饰符
//            int modifiers = declaredConstructor.getModifiers();
//            System.out.println("获取修饰符：" + modifiers);
//            // 获取参数类型
//            Class[] parameterTypes = declaredConstructor.getParameterTypes();
//            System.out.println("获取参数类型：" + Arrays.toString(parameterTypes));
//            for (Class parameterType : parameterTypes) {
//                System.out.println(parameterType.getName());
//            }
//        }


        // 获得该类所有方法
        Method[] declaredMethods = userFilterClass.getDeclaredMethods();
        // 获得所有属性对象
        Field[] declaredFields = userFilterClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            System.out.println(declaredField.getName());
            String fieldGetName = parGetName(declaredField.getName());
            System.out.println(fieldGetName);
            Method fieldGetMet = userFilterClass.getMethod(fieldGetName);
            System.out.println(fieldGetMet);
            System.out.println(fieldGetMet.getName());
        }
//        System.out.println();
//        Method[] declaredMethods = userFilterClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
//            System.out.println(declaredMethod.getName());
//            System.out.println(declaredMethod.getParameterTypes());
//            System.out.println("------------------------");
//        }
//        reflectPrivateField(userFilterClass);
    }

    private void reflectField() {

    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    public static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

}
