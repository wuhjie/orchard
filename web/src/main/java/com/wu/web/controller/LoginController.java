package com.wu.web.controller;

import com.wu.common.interfaces.LoginInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/*
todo: corresponding html page
 */

@Controller
public class LoginController  {

    @RequestMapping("/user/login")
    public String login (
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("user", username);
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
