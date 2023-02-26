package com.bootBoard.controller;

import com.bootBoard.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class IndexController
{
    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public ModelAndView login(ModelAndView mv)
    {
        mv.setViewName("login/login");

        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv)
    {
        Map<String, Object> notice = indexService.selectNoticeList();          // 공지사항 목록 조회

        mv.addObject("notice", notice);

        mv.setViewName("index/index");

        return mv;
    }
}