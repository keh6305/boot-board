package com.bootBoard.mapper;

import com.bootBoard.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexMapper
{
    // 공지사항 목록 조회
    List<NoticeDto> selectNoticeList();
}
