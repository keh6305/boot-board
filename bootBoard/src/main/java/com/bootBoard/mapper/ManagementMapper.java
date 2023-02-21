package com.bootBoard.mapper;

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
    int selectTech(String tech);

    // 기술 등록
    int insertTech(String tech);

    // 기술 수정
    int updateTech(TechDto tech);

    // 기술 삭제
    int deleteTech(int tech_id);
}