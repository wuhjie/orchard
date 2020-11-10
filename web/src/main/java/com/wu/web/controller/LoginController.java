package com.wu.web.controller;

import com.wu.common.domain.ApiResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description
 * @Author wuhjie
 * @Data 2020/11/6 9:44 am
 * @Version 1.0
 **/
public class LoginController {

    @GetMapping("/index")
    public String loadMainPage () {
        return "first Step";
    }

}
