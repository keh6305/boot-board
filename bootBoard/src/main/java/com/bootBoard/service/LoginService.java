package com.bootBoard.service;

import com.bootBoard.entity.User;

public interface LoginService
{
    User loadUserByUsername(String user_login_id);

    int checkId(String user_login_id);

    int updateLoginDate(String user_login_id);
}