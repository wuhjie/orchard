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

    /*
     * 1:
     */
    public static ApiResponse ok() {
        ApiResponse bean = new ApiResponse();
        bean.setCode(200);
        bean.setMsg("success");

        return bean;
    }

    /*
     * 2:success with data
     */
    public static ApiResponse ok(Object data) {
        ApiResponse bean = new ApiResponse();
        bean.setCode(200);
        bean.setMsg("success");
        bean.setData(data);

        return bean;
    }

    /*
     * 3:error
     */
    public static ApiResponse error(int code, String msg) {

        return error(code, msg, null);
    }

    public static ApiResponse error(int code, String msg, String errDetails) {
        ApiResponse resultBean = new ApiResponse();
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        resultBean.setErrDetails(errDetails);

        return resultBean;
    }

}
