package com.bootBoard.mapper;

import com.bootBoard.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmploymentMapper
{
    // 회사 갯수 검색
    int searchCompanyCount(SearchCompanyDto search);

    // 회사 검색
    List<CompanyDto> searchCompany(@Param("search") SearchCompanyDto search, @Param("offset") int offset, @Param("limit") int limit);

    // 메인 지역 목록 조회
    List<AreaDto> selectMainAreaList();

    // 서브 지역 목록 조회
    List<AreaDto> selectSubAreaList(int area_parent);

    // 회사 상세 조사
    CompanyDto selectCompany(int company_id);

    // 회사 등록
    int insertCompany(CompanyDto company);

    // 회사 수정
    int updateCompany(CompanyDto company);

    // 공고 개수 검색
    int searchRecruitmentCount(SearchRecruitmentDto recruitment);

    // 공고 목록 검색
    List<RecruitmentDto> searchRecruitment(@Param("search") SearchRecruitmentDto search, @Param("offset") int offset, @Param("limit") int limit);

    // 사이트 목록 조회
    List<SiteDto> selectSiteList();

    // 공고 등록
    int insertRecruitment(RecruitmentDto recruitment);

    // 기술 목록 조회
    List<TechDto> selectTechList();
}