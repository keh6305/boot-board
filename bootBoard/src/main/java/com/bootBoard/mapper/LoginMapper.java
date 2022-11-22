package com.bootBoard.mapper;

import com.bootBoard.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper
{
    User loadUserByUsername(String user_login_id);

    int checkId(String user_login_id);

    int updateLoginDate(String user_login_id);
}