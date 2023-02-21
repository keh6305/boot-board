package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Support")
public class Support
{
    private int support_id;                 // 지원 PK
    private int user_id;                    // 회원 PK
    private int recruitment_id;             // 공고 PK
    private int company_id;                 // 회사 PK
    private int support_status;             // 지원 상태(0: 진행, 1: 합격, 2: 불합격)
    private String support_date;            // 지원 일자
}