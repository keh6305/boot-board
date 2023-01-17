package com.bootBoard.service;

import java.util.Map;

public interface IndexService
{
    // 공지사항 목록 조회
    Map<String, Object> selectNoticeList();
}
