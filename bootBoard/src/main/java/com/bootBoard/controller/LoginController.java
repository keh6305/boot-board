package com.bootBoard.controller;

import com.bootBoard.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LoginController
{
    @Autowired
    private LoginService loginService;

    // 로그인 페이지
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv)
    {
        mv.setViewName("login/login");

        return mv;
    }

    // 회원가입 페이지
    @RequestMapping("/signup")
    public ModelAndView signup(ModelAndView mv)
    {
        mv.setViewName("login/signup");

        return mv;
    }

    // 아이디 중복 확인
    @PostMapping("/login/checkId")
    public int checkId(@RequestParam("user_login_id") String user_login_id)
    {
        int result = loginService.checkId(user_login_id);

        return result;
    }

    // 로그인시 최종 로그인 날짜 업데이트
    public int updateLoginDate(String user_login_id)
    {
        int result = loginService.updateLoginDate(user_login_id);

        return result;
    }
}