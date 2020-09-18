package com.example.springdatajpademo.common.enums;

/**
 * @ClassName: IsEnum
 * @Description: 是否枚举
 * @author: xiaohaiyan
 * @date: 2020年3月26日下午3:01:27
 */
public enum IsEnum {

    IS("Y", "是"),

    NOT_IS("N", "否");

    IsEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 代码值
     */
    private String code;
    /**
     * 显示名称
     */
    private String name;

    /**
     * 获取代码值
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取显示名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 判断是否是当前枚举
     *
     * @param isEnum
     * @return
     */
    public boolean equals(IsEnum isEnum) {
        if (isEnum == null) {
            return false;
        }
        return this.code.equals(isEnum.code);
    }

    /**
     * 通过code判断是否和当前枚举相等
     *
     * @param code
     * @return
     */
    public boolean equals(String code) {
        return this.code.equals(code);
    }

    /**
     * 通过code获取文档类型
     *
     * @param code 代码值
     * @return
     */
    public static IsEnum getInstance(Object code) {
        for (IsEnum isEnum : IsEnum.values()) {
            if (isEnum.code.equals(code)) {
                return isEnum;
            }
        }
        return null;
    }
}
