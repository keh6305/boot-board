package com.bootBoard.service;

import com.bootBoard.dto.UserDto;
import com.bootBoard.dto.UserUpdateDto;

import java.util.Map;

public interface UserService
{
    Map<String, Object> userSearch(int user_type, int user_status, int keytype, String keyword, int page_num, int limit);

    UserDto selectUser(int user_id);

    int updateUser(UserUpdateDto user);
}