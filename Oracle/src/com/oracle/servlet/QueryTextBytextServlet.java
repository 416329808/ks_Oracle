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
//@WebServlet("/QueryTextBytextServlet")
public class QueryTextBytextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QueryTextBytextServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String searhText=request.getParameter("searhText");
		System.out.println("查询条件----》"+searhText);
		TeacherServiceImpl ts=new TeacherServiceImpl();
		List<Teacher> t=ts.QueryTeacherBytext(searhText);
		
		System.out.println("t----->"+t);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("teachers", t);
		request.getRequestDispatcher("SystemAdmin/teacher_admin.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
