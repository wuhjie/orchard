package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/*
todo: corresponding html page
 */

@RestController
public class CustomerLoginController {

    /**
     * todo
     * @param customerUserName
     * @param password
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/customer/login")
    public ApiResponse<HttpSession> login (
            @RequestParam("customerUserName") String customerUserName,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.isEmpty(customerUserName) && "123".equals(password)) {
            session.setAttribute("user", customerUserName);
            return ApiResponse.ok(session);
        }

        else {
            model.addAttribute("msg", "wrong");
            return ApiResponse.error(3, "wrong password or not exist name");
        }
    }


    @RequestMapping("/customer/logout")
    public ApiResponse<HttpSession> logout(HttpSession session) {
        session.invalidate();
        return ApiResponse.ok();
    }

}
