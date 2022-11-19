package com.bootBoard.controller;

import com.bootBoard.dto.UserDto;
import com.bootBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView userList(ModelAndView mv)
    {
        mv.setViewName("user/userList");

        return mv;
    }

    @RequestMapping("/search")
    public Map<String, Object> userSearch(@RequestParam("user_type") int user_type, @RequestParam("user_status") int user_status, @RequestParam("keytype") int keytype, @RequestParam("keyword") String keyword, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = userService.userSearch(user_type, user_status, keytype, keyword, page_num, limit);

        return result;
    }

    @RequestMapping("/detail/{user_id}")
    public ModelAndView userDetail(ModelAndView mv, @PathVariable("user_id") int user_id)
    {
        UserDto user = userService.selectUser(user_id);

        mv.addObject("user", user);

        mv.setViewName("user/userDetail");

        return mv;
    }

    @GetMapping("/update/{user_id}")
    public ModelAndView userUpdate(ModelAndView mv, @PathVariable("user_id") int user_id)
    {
        UserDto user = userService.selectUser(user_id);

        mv.addObject("user", user);

        mv.setViewName("user/userUpdate");

        return mv;
    }
}