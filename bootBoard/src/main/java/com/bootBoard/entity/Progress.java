package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("Progress")
public class Progress
{
    private int progress_id;                        // 진행 PK
    private int support_id;                         // 지원 PK
    private int procedure_id;                       // 절차 PK
    private int progress_status;                    // 진행 상태(
    private String progress_date;                   // 진행일자
    private String progress_create_date;            // 등록일자
    private String progress_modify_date;            // 수정일자
}