package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("SearchRecruitmentDto")
public class SearchRecruitmentDto
{
    private int site_id;
    private int recruitment_status;
    private int recruitment_type;
    private int min_career;
    private int max_career;
    private String recruitment_start_date;
    private String recruitment_end_date;
    private String keyword;
}