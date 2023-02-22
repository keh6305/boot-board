package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("SearchCompanyDto")
public class SearchCompanyDto
{
    private double max_rating;              // 최고 별점
    private double min_rating;              // 최저 별점
    private int main_area;                  // 메인 지역
    private int sub_area;                   // 서브 지역
    private String keyword;                 // 검색어
}