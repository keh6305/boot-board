package com.bootBoard.service;

import com.bootBoard.dto.UserDto;

import java.util.Map;

public interface UserService
{
    Map<String, Object> userSearch(int user_type, int user_status, int keytype, String keyword, int page_num, int limit);

    UserDto selectUser(int user_id);
}