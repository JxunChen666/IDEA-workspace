package com.fangjian.zhenbao.business.system.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, HttpServletResponse response, Model model) {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        String error = null;
        Cookie[] cookies = req.getCookies();
        String name = "";
        String value = "";
        if (cookies == null) {
            return "login/login";
        }
        for (Cookie c : cookies) {
            //两个参数，一个是cookie的名子，一个是值
            name = c.getName();
            value = c.getValue();
            System.out.println(c.getName() + "--->" + c.getValue());
        }
        if (StringUtils.isEmpty(userName) && StringUtils.isBlank(name)) {
            error = "请输入用户名";
        } else if (StringUtils.isEmpty(passWord) && StringUtils.isBlank(value)) {
            error = "密码不能为空";
        } else if (UnknownAccountException.class.getName().equals(exceptionClassName) && StringUtils.isEmpty(passWord)) {
            error = "账号不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "密码不正确";
        } else if (exceptionClassName != null) {
            error = "其他错误";
        }
        model.addAttribute("error", error);
        model.addAttribute("username", userName);
        model.addAttribute("password", passWord);

        return "login/login";
    }
}
