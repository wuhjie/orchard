package com.wu.internalservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName StandardResponse
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 4:00 pm
 * @Version 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StandardResponse<T> {

    /**
     * return status code
     */
    private String code;

    /**
     * return msg
     */
    private String msg;

    /**
     * is decode
     */
    private Boolean encryption = false;

    /**
     * return msg
     */
    private T data;

    public boolean isOK() {
        return "200".equals(code);
    }
}
