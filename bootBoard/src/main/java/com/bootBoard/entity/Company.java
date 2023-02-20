package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Lazy;

@Getter
@ToString
@Alias("Company")
public class Company
{
    private long company_id;
    private String company_name;
    private float company_rating;
    private int company_main_area;
    private int company_sub_area;
    private String company_detail_area;
}