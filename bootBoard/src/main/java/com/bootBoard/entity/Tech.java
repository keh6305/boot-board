package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Tech")
public class Tech
{
    private int tech_id;            // 기술 PK
    private String tech;            // 기술명
}