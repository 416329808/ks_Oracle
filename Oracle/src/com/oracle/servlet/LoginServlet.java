package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.service.LoginService;
import com.oracle.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService= new LoginServiceImpl();
	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jump = request.getParameter("jump");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		login(request, response);


	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// 获取用户输入的账户
		String account = request.getParameter("firstname");
		// 获取用户输入的密码
		String password = request.getParameter("password");

		// 获取登录类型
		checkperson checkperson1 = null;
			try {
				checkperson1 = loginService.Login(account,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String message="登陆成功";
			if (checkperson1!=null) {
				String type =checkperson1.getStyle();
				request.setAttribute("type", type);
				request.setAttribute("account", account);
				request.setAttribute("message", message);
				request.getRequestDispatcher("login.jsp").forward(request,response);

				}else {
					message="用户名或密码错误";
					request.setAttribute("message", message);
					request.getRequestDispatcher("login.jsp").forward(request,response);
				}

			}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
