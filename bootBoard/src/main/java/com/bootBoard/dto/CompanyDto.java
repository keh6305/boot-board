package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CompanyDto")
public class CompanyDto
{
    private long company_id;                        // 회사 PK
    private String company_name;                    // 회사명
    private double company_rating;                  // 회사 별점
    private String company_introduce;               // 회사 소개
    private String company_welfare;                 // 회사 복지
    private int company_main_area;                  // 회사 주소
    private int company_sub_area;                   // 회사 주소
    private String company_detail_area;             // 회사 상세 주소
    private String company_create_date;             // 등록일자
    private String company_modify_date;             // 수정일자

    private String main_area;
    private String sub_area;
}