package com.bootBoard.config.security;

import com.bootBoard.entity.User;
import com.bootBoard.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
	@Autowired
	private PasswordEncoder passwordEncoder;

	private LoginService loginService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		User user = (User) loginService.loadUserByUsername(authentication.getName());

		if (!passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword()))
		{
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
		}
		else
		{
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return true;
	}
}