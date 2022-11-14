package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("UserDto")
public class UserDto
{
    private int user_id;
    private String user_login_id;
    private String user_name;
    private String user_nickname;
    private String user_phone;
    private String user_email;
    private int user_type;
    private int user_status;
    private String user_authority;
    private String user_login_date;
    private String user_create_date;
    private String user_modify_date;
}