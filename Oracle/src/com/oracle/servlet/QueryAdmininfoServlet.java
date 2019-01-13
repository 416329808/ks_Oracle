package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.AdminInfodao;
import com.oracle.daomain.Admin;
import com.oracle.daomain.student;
import com.oracle.service.AdmininfoService;
import com.oracle.service.studentService;
import com.oracle.service.impl.AdmininfoServiceImpl;
import com.oracle.service.impl.studentServiceImpl;


//@WebServlet("/QueryAdmininfoServlet")
public class QueryAdmininfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QueryAdmininfoServlet() {
        super();
       
    }

	/**
	 *将本管理员的信息查出来显示在个人信息页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String ID=request.getParameter("ID");	 
		    AdmininfoService ad =new AdmininfoServiceImpl();
		    
		    Admin admin;
			try {
				admin = ad.findAdminByid(ID);
				
				request.setAttribute("ID", ID);
				request.setAttribute("admin", admin);
			    request.getRequestDispatcher("/SystemAdmin/individual_info.jsp").forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
