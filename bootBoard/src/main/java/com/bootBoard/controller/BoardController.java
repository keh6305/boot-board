package com.bootBoard.controller;

import com.bootBoard.dto.NoticeDto;
import com.bootBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController
{
    @Autowired
    private BoardService boardService;

    // 공지사항 목록 페이지
    @RequestMapping("/notice/list")
    public ModelAndView noticeList(ModelAndView mv)
    {
        mv.setViewName("board/noticeList");

        return mv;
    }

    // 공지사항 목록 조회
    @PostMapping("/notice/search")
    public Map<String, Object> noticeSearch(@RequestParam("user_type") int user_type, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = boardService.noticeSearch(user_type, page_num, limit);

        return result;
    }

    // 공지사항 상세 페이지
    @RequestMapping("/notice/detail/{notice_id}")
    public ModelAndView noticeDetail(ModelAndView mv, @PathVariable("notice_id") int notice_id)
    {
        NoticeDto notice = boardService.selectNotice(notice_id);

        mv.addObject("notice", notice);

        mv.setViewName("board/noticeDetail");

        return mv;
    }

    // 공지사항 등록 페이지
    @GetMapping("/notice/insert")
    public ModelAndView noticeInsert(ModelAndView mv)
    {
        mv.setViewName("board/noticeInsert");

        return mv;
    }

    // 공지사항 등록
    @PostMapping("/notice/insert")
    public int insertNotice(NoticeDto notice)
    {
        int result = boardService.insertNotice(notice);

        return result;
    }

    // 공지사항 수정 페이지
    @GetMapping("/notice/update/{notice_id}")
    public ModelAndView noticeUpdate(ModelAndView mv, @PathVariable("notice_id") int notice_id)
    {
        NoticeDto notice = boardService.selectNotice(notice_id);

        mv.addObject("notice", notice);

        mv.setViewName("board/noticeUpdate");

        return mv;
    }

    // 공지사항 수정
    @PutMapping("/notice/update")
    public int updateNotice(NoticeDto notice)
    {
        int result = boardService.updateNotice(notice);

        return result;
    }
}