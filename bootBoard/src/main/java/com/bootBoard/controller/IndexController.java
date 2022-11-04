package com.bootBoard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class IndexController
{
    @RequestMapping("/")
    public ModelAndView login(ModelAndView mv)
    {
        mv.setViewName("login/login");

        return mv;
    }
}