package com.bootBoard.service;

import java.util.Map;

public interface UserService
{
    Map<String, Object> userSearch(int user_type, int user_status, int keytype, String keyword, int page_num, int limit);
}