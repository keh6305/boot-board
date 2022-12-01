package com.bootBoard.controller;

import com.bootBoard.entity.User;
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

    // 로그인
    public Object loadUserByUsername(String user_login_id)
    {
        return loginService.loadUserByUsername(user_login_id);
    }

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

    // 아이디, 닉네임 중복 확인
    @PostMapping("/login/checkJoin")
    public String checkJoin(@RequestParam("user_login_id") String user_login_id, @RequestParam("user_nickname") String user_nickname)
    {
        String result = loginService.checkJoin(user_login_id, user_nickname);

        return result;
    }

    // 회원가입
    @RequestMapping("/join")
    public int join(User user)
    {
        int result = loginService.join(user);

        return result;
    }

    // 로그인시 최종 로그인 날짜 업데이트
    public int updateLoginDate(String user_login_id)
    {
        int result = loginService.updateLoginDate(user_login_id);

        return result;
    }
}