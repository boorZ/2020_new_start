package com.example.springdatajpademo.utils;

/**
 * Created by Zhang Hong Zhi on 2017/3/26.
 */
public class NoaskException extends  RuntimeException{
    private static final String DEFAULT_CODE;

    static {
        DEFAULT_CODE = "basic";
    }

    private String errorCode;

    public NoaskException(String message){
        super(message);
        this.errorCode = DEFAULT_CODE;
    }

    public NoaskException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public String getCode() {
        return this.errorCode;
    }
}
