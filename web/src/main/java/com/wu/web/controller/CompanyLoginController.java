package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import com.wu.web.service.impl.CompanyImpl;
import org.apache.coyote.http11.Http11OutputBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName CompanyLoginController
 * @Description
 * @Author wuhjie
 * @Data 2020/11/4 11:45 am
 * @Version 1.0
 **/

@RestController
public class CompanyLoginController {

    /**
     * todo
     */

    CompanyImpl companyimpl;

    @RequestMapping("/company/login")
    public ApiResponse<HttpSession> login (
            @RequestParam("companyUserName") String companyUserName,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.isEmpty(companyUserName) && "123".equals(password)) {
            session.setAttribute("user", companyUserName);
            return ApiResponse.ok(session);
        }

        else {
            return ApiResponse.error(3, "wrong password...");
        }
    }

    @RequestMapping("/company/logout")
    public ApiResponse<HttpSession> logout(HttpSession session) {
        session.invalidate();
        return ApiResponse.ok();
    }

}
