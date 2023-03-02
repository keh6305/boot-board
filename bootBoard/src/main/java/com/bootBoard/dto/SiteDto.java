package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("SiteDto")
public class SiteDto
{
    private int site_id;
    private String site;
}