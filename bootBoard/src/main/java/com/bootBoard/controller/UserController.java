package com.bootBoard.controller;

import com.bootBoard.dto.UserDto;
import com.bootBoard.dto.UserUpdateDto;
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

    // 회원 목록
    @RequestMapping("/list")
    public ModelAndView userList(ModelAndView mv)
    {
        mv.setViewName("user/userList");

        return mv;
    }

    // 회원 검색
    @RequestMapping("/search")
    public Map<String, Object> userSearch(@RequestParam("user_type") int user_type, @RequestParam("user_status") int user_status, @RequestParam("keytype") int keytype, @RequestParam("keyword") String keyword, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = userService.userSearch(user_type, user_status, keytype, keyword, page_num, limit);

        return result;
    }

    // 회원 상세 페이지
    @RequestMapping("/detail/{user_id}")
    public ModelAndView userDetail(ModelAndView mv, @PathVariable("user_id") int user_id)
    {
        UserDto user = userService.selectUser(user_id);

        mv.addObject("detail", user);

        mv.setViewName("user/userDetail");

        return mv;
    }

    // 회원 수정 페이지
    @RequestMapping("/update/{user_id}")
    public ModelAndView userUpdate(ModelAndView mv, @PathVariable("user_id") int user_id)
    {
        UserDto user = userService.selectUser(user_id);

        mv.addObject("detail", user);

        mv.setViewName("user/userUpdate");

        return mv;
    }

    // 회원 수정
    @PostMapping("/update")
    public int updateUser(UserUpdateDto user)
    {
        return userService.updateUser(user);
    }
}