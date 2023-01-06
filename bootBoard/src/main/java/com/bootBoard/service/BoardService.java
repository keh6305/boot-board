package com.bootBoard.service;

import com.bootBoard.dto.NoticeDto;

import java.util.Map;

public interface BoardService
{
    // 공지사항 조회
    Map<String, Object> noticeSearch(int user_type, int page_num, int limit);

    // 공지사항 등록
    int insertNotice(NoticeDto notice);
}