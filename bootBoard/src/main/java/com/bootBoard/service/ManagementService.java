package com.bootBoard.service;

import com.bootBoard.dto.TechDto;

import java.util.Map;

public interface ManagementService
{
    // 기술 검색
    Map<String, Object> searchTech(String keyword, int page_num, int limit);

    // 기술 조회
    int selectTech(String tech);

    // 기술 등록
    int insertTech(String tech);

    // 기술 수정
    int updateTech(TechDto tech);

    // 기술 삭제
    int deleteTech(int tech_id);
}