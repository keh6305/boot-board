package com.bootBoard.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Alias("User")
public class User implements UserDetails
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
    private String user_authority;          // 회원 권한
    private String user_login_date;
    private String user_create_date;
    private String user_modify_date;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public String getUsername()
    {
        return user_login_id;
    }

    @Override
    public String getPassword()
    {
        return user_login_pw;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}