package com.bootBoard.controller;

import com.bootBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController
{
    private BoardService boardService;

    @RequestMapping("/notice/list")
    public ModelAndView boardList(ModelAndView mv)
    {
        mv.setViewName("board/noticeList");

        return mv;
    }
}