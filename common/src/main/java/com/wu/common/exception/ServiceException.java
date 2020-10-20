package com.wu.common.exception;

import java.util.Objects;

/**
 * @ClassName ServiceException
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 2:56 pm
 * @Version 1.0
 **/
public class ServiceException extends RuntimeException{

    private final Integer code;
    private final String msg;

    public final static String DELETE_FAILURE_MSG = "failed to delete, plz try again";
    public final static String CREATE_FAILURE_MSG = "failed to add, plz try again";
    public final static String UPDATE_FAILURE_MSG = "failed to update, plz try again";

    public ServiceException(int code, String msg, Throwable cause) {
//        super()
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {

        return code;
    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }

    public static ServiceException build(int code, String msg, Throwable cause) {

        return new ServiceException(code, msg, cause);
    }

    public static ServiceException build(ExceptionEnum exceptionEnum, String msg) {
        Objects.requireNonNull(exceptionEnum);
        return build(exceptionEnum.getCode(), msg, null);
    }

    public static ServiceException build(String msg) {
        Objects.requireNonNull(msg);
        return build(ExceptionEnum.BUSINESS_EXCEPTION, msg);
    }

    public static ServiceException build(ExceptionEnum exceptionEnum) {
        Objects.requireNonNull(exceptionEnum);
        return build(exceptionEnum.getCode(), exceptionEnum.getMessage(), null);
    }

    public static ServiceException build(ExceptionEnum exceptionEnum, Throwable cause) {
        Objects.requireNonNull(exceptionEnum);
        return build(exceptionEnum.getCode(), exceptionEnum.getMessage(), null);
    }

    public static ServiceException build(ExceptionEnum exceptionEnum, String msg ,Throwable cause) {
        Objects.requireNonNull(exceptionEnum);
        return build(exceptionEnum.getCode(), msg, null);
    }

}
