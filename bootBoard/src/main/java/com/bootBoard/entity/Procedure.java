package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Procedure")
public class Procedure
{
    private int procedure_id;                   // 절차 PK
    private int recruitment_id;                 // 공고 PK
    private String procedure;                   // 절차
    private String procedure_comment;           // 절차 설명
    private int procedure_type;                 // 절차 유형(0: 서류, 1: 테스트, 2: 과제, 3: 면접)
    private int procedure_index;                // 절차 순서
}
