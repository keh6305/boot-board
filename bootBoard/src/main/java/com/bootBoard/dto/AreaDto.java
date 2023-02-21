package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("AreaDto")
public class AreaDto
{
    private int area_id;                // 지역 PK
    private String area;                // 지역명
    private int area_parent;            // 상위 지역 PK
    private String parent_name;         // 상위 지역명
}