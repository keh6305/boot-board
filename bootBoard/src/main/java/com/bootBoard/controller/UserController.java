package com.bootBoard.controller;

import com.bootBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService service;

    @RequestMapping("/list")
    public ModelAndView userList(ModelAndView mv)
    {
        mv.setViewName("user/userList");

        return mv;
    }

    @RequestMapping("/search")
    public Map<String, Object> userSearch(@RequestParam("user_type") int user_type, @RequestParam("user_status") int user_status, @RequestParam("keytype") int keytype, @RequestParam("keyword") String keyword, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = service.userSearch(user_type, user_status, keytype, keyword, page_num, limit);

        return result;
    }
}