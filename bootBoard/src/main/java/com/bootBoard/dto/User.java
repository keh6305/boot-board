package com.bootBoard.dto;

import lombok.Data;

@Data
public class User
{
    private int user_id;
    private String user_login_id;
    private String user_login_pw;
    private String user_nickname;
}