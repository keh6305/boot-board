package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Recruitment")
public class Recruitment
{
    private int recruitment_id;                             // 공고 PK
    private int company_id;                                 // 회사 PK
    private String recruitment_site;                        // 공고 사이트
    private String recruitment_url;                         // 공고 URL
    private int recruitment_career;                         // 경력
    private String recruitment_qualification;               // 자격요건
    private String recruitment_work;                        // 주요업무
    private String recruitment_preferential;                // 우대사항
    private int recruitment_status;                         // 공고 상태
    private int recruitment_type;                           // 공고 유형
    private int recruitment_salary;                         // 급여
    private int recruitment_compensation;                   // 축하금
    private String recruitment_start_date;                  // 공고 시작일
    private String recruitment_end_date;                    // 공고 마감일
    private String recruitment_create_date;                 // 공고 등록일
    private String recruitment_modify_date;                 // 공고 수정일
}