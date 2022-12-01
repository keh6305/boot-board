package com.bootBoard.service;

import com.bootBoard.entity.User;

public interface LoginService
{
    User loadUserByUsername(String user_login_id);

    String checkJoin(String user_login_id, String user_nickname);

    int join(User user);

    int updateLoginDate(String user_login_id);
}