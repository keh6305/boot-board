package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RecruitmentDto")
public class RecruitmentDto
{
    private int recruitment_id;                             // 공고 PK
    private int company_id;                                 // 회사 PK
    private int site_id;                                    // 사이트 PK
    private String recruitment_url;                         // 공고 URL
    private int recruitment_career;                         // 경력
    private String recruitment_qualification;               // 자격 요건
    private String recruitment_work;                        // 주요 업무
    private String recruitment_preferential;                // 우대 사항
    private int recruitment_status;                         // 공고 상태(0: 대기, 1: 정상, 2: 마감)
    private int recruitment_type;                           // 공고 유형(0: 정규직, 1: 비정규직, 2: 인턴)
    private int recruitment_salary;                         // 급여
    private int recruitment_compensation;                   // 축하금
    private String recruitment_start_date;                  // 공고 시작일
    private String recruitment_end_date;                    // 공고 마감일
    private String recruitment_create_date;                 // 공고 등록일
    private String recruitment_modify_date;                 // 공고 수정일

    private String company_name;
    private String site;
}