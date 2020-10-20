package com.wu.core.service;

import com.wu.common.domain.ApiResponse;
import com.wu.common.basic.LoginInfoVo;

import java.util.Set;

/**
 * @ClassName CustomerAccountService
 * @Description
 * @Author nullacc
 * @Data 2020/10/15 11:18 am
 * @Version 1.0
 **/
public interface CustomerAccountService {

    public String getCustomerTokenCache(Integer cumstomerId);

    public void clearToken(Set<Integer> customerIds);

    public void logout(String token) throws Exception;

    LoginInfoVo login(String account, String password) throws Exception;

    ApiResponse forgetPassword(String phone, String smsCode, String firstPassword, String secondPassword) throws Exception;

}
