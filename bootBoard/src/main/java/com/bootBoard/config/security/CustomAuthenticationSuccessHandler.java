package com.bootBoard.config.security;

import com.bootBoard.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	private String defaultUrl = "/index";

	@Autowired
	private LoginController loginController;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		
		session.setAttribute("login", true);
		session.setAttribute("user_login_id", authentication.getName());
		session.setMaxInactiveInterval(3600 * 24);

		int loginDate = loginController.updateLoginDate(authentication.getName());

		response.setStatus(200);
//		response.getWriter().print(defaultUrl);
//		response.getWriter().flush();

		response.sendRedirect(request.getContextPath() + defaultUrl);
	}

	public void setDefaultUrl(String defaultUrl)
	{
		this.defaultUrl = defaultUrl;
	}
}