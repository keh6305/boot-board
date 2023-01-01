package com.bootBoard.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Notice")
public class Notice
{
    private int notice_id;
    private String notice_title;
    private String notice_content;
    private int notice_status;              // 공지사항 상태(0: 미공개, 1: 공개)
    private String notice_create_date;
    private String notice_modify_date;
}