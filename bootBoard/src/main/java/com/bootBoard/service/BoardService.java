package com.bootBoard.service;

import com.bootBoard.dto.NoticeDto;

import java.util.Map;

public interface BoardService
{
    // 공지사항 목록 조회
    Map<String, Object> noticeSearch(int user_type, int page_num, int limit);

    // 공지사항 조회
    NoticeDto selectNotice(int notice_id);

    // 공지사항 등록
    int insertNotice(NoticeDto notice);

    // 공지사항 수정
    int updateNotice(NoticeDto notice);
}