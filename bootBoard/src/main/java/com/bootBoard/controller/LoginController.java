package com.bootBoard.controller;

import com.bootBoard.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv)
    {
        mv.setViewName("login/login");

        return mv;
    }

    public int updateLoginDate(String user_login_id)
    {
        int result = loginService.updateLoginDate(user_login_id);

        return result;
    }
}