package com.bootBoard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController
{
    @RequestMapping("/list")
    public ModelAndView userList(ModelAndView mv)
    {
        mv.setViewName("user/userList");

        return mv;
    }
}