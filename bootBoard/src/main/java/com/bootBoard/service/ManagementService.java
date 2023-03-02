package com.bootBoard.service;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.SiteDto;
import com.bootBoard.dto.TechDto;

import java.util.List;
import java.util.Map;

public interface ManagementService
{
    // 기술 검색
    Map<String, Object> searchTech(String keyword, int page_num, int limit);

    // 기술 등록
    int insertTech(String tech);

    // 기술 수정
    int updateTech(TechDto tech);

    // 기술 삭제
    int deleteTech(int tech_id);

    // 지역 목록 조회
    List<AreaDto> selectAreaList();

    // 지역 검색
    Map<String, Object> searchArea(String keyword, int parent, int page_num, int limit);

    // 지역 등록
    int insertArea(AreaDto area);

    // 지역 수정
    int updateArea(AreaDto area);

    // 지역 삭제
    int deleteArea(int area_id);

    // 사이트 검색
    Map<String, Object> searchSite(String keyword, int page_num, int limit);

    // 사이트 등록
    int insertSite(String site);

    // 사이트 수정
    int updateSite(SiteDto site);

    // 사이트 삭제
    int deleteSite(int site_id);
}