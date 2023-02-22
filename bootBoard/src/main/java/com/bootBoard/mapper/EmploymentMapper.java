package com.bootBoard.mapper;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.CompanyDto;
import com.bootBoard.dto.SearchCompanyDto;
import com.bootBoard.dto.TechDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmploymentMapper
{
    // 회사 갯수 검색
    int searchCompanyCount(SearchCompanyDto search);

    // 회사 검색
    List<TechDto> searchCompany(@Param("search") SearchCompanyDto search, @Param("offset") int offset, @Param("limit") int limit);

    // 메인 지역 목록 조회
    List<AreaDto> selectMainAreaList();

    // 서브 지역 목록 조회
    List<AreaDto> selectSubAreaList(int area_parent);

    // 기술 목록 조회
    List<TechDto> selectTechList();

    // 기술 등록
    int insertCompany(CompanyDto company);
}