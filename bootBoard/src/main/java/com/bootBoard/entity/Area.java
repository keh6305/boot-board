package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Area")
public class Area
{
    private int area_id;                // 지역 PK
    private String area;                // 지역명
    private int area_parent;            // 상위 지역
}