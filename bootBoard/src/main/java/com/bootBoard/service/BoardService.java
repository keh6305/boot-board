package com.bootBoard.service;

import java.util.Map;

public interface BoardService
{
    // 공지사항 조회
    Map<String, Object> noticeSearch(int user_type, int page_num, int limit);
}