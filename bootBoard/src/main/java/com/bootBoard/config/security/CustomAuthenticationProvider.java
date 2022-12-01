package com.bootBoard.config.security;

import com.bootBoard.controller.LoginController;
import com.bootBoard.entity.User;
import com.bootBoard.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
	@Autowired
	private LoginController loginController;

	@Autowired @Lazy
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		User user = (User)loginController.loadUserByUsername(authentication.getName());

		if(user == null)
		{
			throw new UsernameNotFoundException("해당 아이디가 없습니다.");
		}

		if(!passwordEncoder.matches(authentication.getCredentials().toString(), user.getUser_login_pw()) || user == null)
		{
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}

		if(user.getUser_status() == 0)
		{
			throw new BadCredentialsException("회원가입이 승인되지 않았습니다.");
		}

		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return true;
	}
}