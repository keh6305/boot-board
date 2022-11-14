package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Pagination")
public class Pagination
{
    private int count;
    private int page_num;
    private int start_page;
    private int end_page;
    private int max_page;
    private int offset;
    private int limit;
}