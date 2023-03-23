package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Step")
public class Step
{
    private int step_id;                   // 절차 PK
    private int recruitment_id;            // 공고 PK
    private String step;                   // 절차
    private String step_comment;           // 절차 설명
    private int step_type;                 // 절차 유형(0: 서류, 1: 테스트, 2: 과제, 3: 면접)
    private int step_index;                // 절차 순서
}
