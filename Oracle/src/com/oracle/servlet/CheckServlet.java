package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CheckServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户输入的账户
		String account = request.getParameter("account");
		System.out.println(account);
		String type = request.getParameter("type");
		System.out.println(type);
		if (type.equals("1")) {
			request.setAttribute("account", account);
			request.getRequestDispatcher("/Student/student.jsp").forward(request, response);
		} else if (type.equals("2")) {
			request.setAttribute("account", account);
			request.getRequestDispatcher("/Teacher/Teacher.jsp").forward(request, response);
		} else if (type.equals("3")) {
			request.setAttribute("account", account);
			request.getRequestDispatcher("/AffairAdmin/affair_admin.jsp").forward(request, response);
		} else if (type.equals("4")) {
			request.setAttribute("account", account);
			request.getRequestDispatcher("/SystemAdmin/system_admin.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
