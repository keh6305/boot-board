package com.bootBoard.service;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.CompanyDto;
import com.bootBoard.dto.SearchCompanyDto;
import com.bootBoard.dto.TechDto;

import java.util.List;
import java.util.Map;

public interface EmploymentService
{
    // 회사 검색
    Map<String, Object> searchCompany(SearchCompanyDto search, int page_num, int limit);

    // 메인 지역 목록 조회
    List<AreaDto> selectMainAreaList();

    // 서브 지역 목록 조회
    List<AreaDto> selectSubAreaList(int area_parent);

    // 기술 목록 조회
    List<TechDto> selectTechList();

    // 기술 등록
    int insertCompany(CompanyDto company);
}