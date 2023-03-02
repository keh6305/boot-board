package com.bootBoard.service;

import com.bootBoard.dto.*;

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

    // 공고 검색
    Map<String, Object> searchRecruitment(SearchRecruitmentDto search, int page_num, int limit);

    // 사이트 목록 조회
    List<SiteDto> selectSiteList();

    // 공고 등록
    int insertRecruitment(RecruitmentDto recruitment);

    // 기술 목록 조회
    List<TechDto> selectTechList();
}