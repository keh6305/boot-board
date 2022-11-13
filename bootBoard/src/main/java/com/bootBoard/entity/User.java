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
    private int user_type;
    private int user_status;
    private String user_authority;
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