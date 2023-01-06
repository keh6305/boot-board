package com.bootBoard.mapper;

import com.bootBoard.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper
{
    // 공지사항 갯수 조회
    int selectNoticeCount(int user_type);

    // 공지사항 목록 조회
    List<NoticeDto> selectNoticeList(@Param("user_type") int user_type, @Param("offset") int offset, @Param("limit") int limit);

    // 공지사항 조회
    NoticeDto selectNotice(int notice_id);

    // 공지사항 등록
    int insertNotice(NoticeDto notice);

}