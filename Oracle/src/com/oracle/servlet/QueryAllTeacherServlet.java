package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Teacher;
import com.oracle.service.impl.TeacherServiceImpl;

//@WebServlet("/QueryAllTeacherServlet")
public class QueryAllTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public QueryAllTeacherServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		TeacherServiceImpl ts=new TeacherServiceImpl();
		List<Teacher> teachers=ts.QueryAllTeacher();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("servlet"+teachers);
		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("SystemAdmin/teacher_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
