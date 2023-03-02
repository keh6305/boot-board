package com.bootBoard.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@ToString
@Alias("Site")
public class Site
{
    private int site_id;
    private String site;
}