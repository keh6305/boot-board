package com.bootBoard.serviceImpl;

import com.bootBoard.entity.User;
import com.bootBoard.mapper.LoginMapper;
import com.bootBoard.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String user_login_id)
    {
        User user = loginMapper.loadUserByUsername(user_login_id);

        return user;
    }

    @Override
    public String checkJoin(String user_login_id, String user_nickname)
    {
        String result = "success";

        int checkId = loginMapper.checkId(user_login_id);
        int checkNickname = loginMapper.checkNickname(user_nickname);

        if(checkId != 0)
        {
            result = "failId";
        }
        else if(checkNickname != 0)
        {
            result = "failNickname";
        }

        return result;
    }

    @Override
    public int join(User user)
    {
        String password = passwordEncoder.encode(user.getUser_login_pw());

        user.setUser_login_pw(password);

        int result = loginMapper.join(user);

        return result;
    }

    @Override
    public int updateLoginDate(String user_login_id)
    {
        int result = loginMapper.updateLoginDate(user_login_id);

        return result;
    }
}
