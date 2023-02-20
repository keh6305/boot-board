package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("TechStack")
public class TechStack
{
    private int tech_stack_id;          // 기술스택 PK
    private int recruitment_id;         // 공고 PK
    private int tech_id;                // 기술 PK
}