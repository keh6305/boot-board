package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("UserDTO")
public class UserDto
{
    private int user_id;
    private String user_login_id;
    private String user_login_pw;
    private String user_nickname;
}