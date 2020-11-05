package com.wu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/*
todo: corresponding html page
 */

@Controller
public class CustomerLoginController {

    /**
     * todo
     * @param customerUserName
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/login")
    public String login (
            @RequestParam("customerUserName") String customerUserName,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (!StringUtils.isEmpty(customerUserName) && "123".equals(password)) {
            session.setAttribute("user", customerUserName);
            return "redirect:/main.html";
        }
//        CustomerDao customerDao;


//        Customer currentCustomer = customerDao.queryByCustomerName(customerUserName);
//
//        if {
//
//        }
//
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
