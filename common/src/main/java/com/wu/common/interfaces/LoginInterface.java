package com.wu.common.interfaces;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface LoginInterface {


    String login(String username, String password, Model model, HttpSession session);

    String logout(HttpSession session);
}
