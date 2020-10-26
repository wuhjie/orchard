package com.wu.common.exception;

/**
 * @ClassName ExceptionEnum
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 2:51 pm
 * @Version 1.0
 **/
public enum ExceptionEnum implements IException{

    /**
     *
     */
    DEFAULT_EXCEPTION(-2, "something wrong with the internet"),
    PARAM_BINDING_EXCEPTION(-2, "please check the parameters"),
    BUSINESS_EXCEPTION(-3, "abnormal business"),
    OPTIMISTIC_LOCKER_EXCEPTION(-11, "the system is busy, plez try latter"),
    SYS_ERROR(-9, "system internal error"),
    EXPIRED_TOKEN(-12, "expiration error"),
    NOT_LOGGED(-13, "not logged"),
    USER_DOES_NOT_EXIST(-14, "not existed user"),
    USER_PASSWORD_ERROR(-15, "an error occur in account or password"),;

    private final int code;

    ExceptionEnum(int code, String msg) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
