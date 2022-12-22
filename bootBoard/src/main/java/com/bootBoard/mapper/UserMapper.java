package com.bootBoard.mapper;

import com.bootBoard.dto.UserDto;
import com.bootBoard.dto.UserUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper
{
    int selectUserCount(@Param("user_type") int user_type, @Param("user_status") int user_status, @Param("keytype") int keytype, @Param("keyword") String keyword);

    List<UserDto> selectUserList(@Param("user_type") int user_type, @Param("user_status") int user_status, @Param("keytype") int keytype, @Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);

    UserDto selectUser(int user_id);

    int updateUser(UserUpdateDto user);
}