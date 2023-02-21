package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("TechDto")
public class TechDto
{
    private int tech_id;            // 기술 PK
    private String tech;            // 기술명
}