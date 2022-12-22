package com.bootBoard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("UserUpdateDto")
public class UserUpdateDto
{
    private int user_id;
    private String user_login_id;
    private String user_login_pw;
    private String user_name;
    private String user_nickname;
    private String user_phone;
    private String user_email;
    private int user_type;                  // 회원 유형(0: 최고관리자, 1: 관리자, 2: 일반)
    private int user_status;                // 회원 상태(0: 대기, 1: 정상, 2: 정지, 9: 탈퇴)

    private String encodingPassword;
}
