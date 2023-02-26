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

    // 회사 상세 조회
    CompanyDto selectCompany(int company_id);

    // 회사 등록
    int insertCompany(CompanyDto company);

    // 회사 수정
    int updateCompany(CompanyDto company);

    // 기술 목록 조회
    List<TechDto> selectTechList();
}