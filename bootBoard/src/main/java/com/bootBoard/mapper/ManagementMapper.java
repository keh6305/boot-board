package com.bootBoard.mapper;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.SiteDto;
import com.bootBoard.dto.TechDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagementMapper
{
    // 기술 갯수 검색
    int searchTechCount(String keyword);

    // 기술 검색
    List<TechDto> searchTech(@Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);

    // 기술 조회
    int selectTechCheck(String tech);

    // 기술 등록
    int insertTech(String tech);

    // 기술 수정
    int updateTech(TechDto tech);

    // 기술 삭제
    int deleteTech(int tech_id);

    // 지역 목록 조회
    List<AreaDto> selectAreaList();

    // 지역 갯수 검색
    int searchAreaCount(@Param("keyword") String keyword, @Param("parent") int parent);

    // 지역 검색
    List<AreaDto> searchArea(@Param("keyword") String keyword, @Param("parent") int parent, @Param("offset") int offset, @Param("limit") int limit);

    // 지역 조회
    int selectAreaCheck(AreaDto area);

    // 지역 등록
    int insertArea(AreaDto area);

    // 지역 수정
    int updateArea(AreaDto area);

    // 지역 삭제
    int deleteArea(int area_id);

    // 사이트 갯수 검색
    int searchSiteCount(String keyword);

    // 사이트 검색
    List<SiteDto> searchSite(@Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);

    // 사이트 여부 조회
    int selectSiteCheck(String site);

    // 사이트 등록
    int insertSite(String site);

    // 사이트 수정
    int updateSite(SiteDto site);

    // 사이트 삭제
    int deleteSite(int site_id);
}