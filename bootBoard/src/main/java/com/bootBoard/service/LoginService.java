package com.bootBoard.service;

import com.bootBoard.entity.User;

public interface LoginService
{
    User loadUserByUsername(String user_login_id);
}