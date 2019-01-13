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


@WebServlet("/QueryTeacherByIdServlet")
public class QueryTeacherByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public QueryTeacherByIdServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				String teacherID=request.getParameter("TeacherID");
				TeacherServiceImpl ts=new TeacherServiceImpl();
				Teacher t=ts.QueryTeacherByID(teacherID);
				response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				request.setAttribute("teacher", t);
				request.getRequestDispatcher("SystemAdmin/change_teacher.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
