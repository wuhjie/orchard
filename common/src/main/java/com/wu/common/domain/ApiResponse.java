package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName ApiResponse
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 11:37 am
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private String msg;
    private String errDetails;
    private T data;

    //1
    public static ApiResponse ok() {
        ApiResponse bean = new ApiResponse();
        bean.setCode(200);
        bean.setMsg("success");

        return bean;
    }

    //2
    public static ApiResponse ok(Object data) {
        ApiResponse bean = new ApiResponse();
        bean.setCode(200);
        bean.setMsg("success");

        return bean;
    }

    //3
    public static ApiResponse error(int code, String msg) {
        return error(code, msg);
    }

    public static ApiResponse error(int code, String msg, String errDetails) {
        ApiResponse bean = new ApiResponse();
        bean.setCode(code);
        bean.setMsg(msg);
        bean.setErrDetails(errDetails);

        return error(code, msg);
    }

}
