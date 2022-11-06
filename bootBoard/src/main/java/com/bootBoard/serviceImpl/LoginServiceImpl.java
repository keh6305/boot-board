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
        System.out.println("user_login_id = " + user_login_id);
        User user = loginMapper.loadUserByUsername(user_login_id);
        System.out.println("user service = " + user);

        return user;
    }
}
