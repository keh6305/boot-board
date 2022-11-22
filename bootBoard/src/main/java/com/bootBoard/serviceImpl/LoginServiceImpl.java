package com.bootBoard.serviceImpl;

import com.bootBoard.entity.User;
import com.bootBoard.mapper.LoginMapper;
import com.bootBoard.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User loadUserByUsername(String user_login_id)
    {
        User user = loginMapper.loadUserByUsername(user_login_id);

        return user;
    }

    @Override
    public int checkId(String user_login_id)
    {
        int result = loginMapper.checkId(user_login_id);

        return result;
    }

    @Override
    public int updateLoginDate(String user_login_id)
    {
        int result = loginMapper.updateLoginDate(user_login_id);

        return result;
    }
}
