package com.wu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName CompanyLoginController
 * @Description
 * @Author wuhjie
 * @Data 2020/11/4 11:45 am
 * @Version 1.0
 **/

@Controller
public class CompanyLoginController {

    /**
     * todo
     */
    @RequestMapping("/company/login")
    public String login (
            @RequestParam("companyUserName") String companyUserName,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.isEmpty(companyUserName) && "123".equals(password)) {
            session.setAttribute("user", companyUserName);
            return "redirect:/main.html";
        }

        else {
            model.addAttribute("msg", "wrong");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

}
