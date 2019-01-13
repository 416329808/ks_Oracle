package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Teacher;
import com.oracle.daomain.student;
import com.oracle.service.StudentadminService;
import com.oracle.service.impl.StudentadminServiceImpl;
import com.oracle.service.impl.TeacherServiceImpl;


//@WebServlet("/QueryStudentByIdServlet")
public class QueryStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QueryStudentByIdServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String teacherID=request.getParameter("StudentID");
		StudentadminService stu=new StudentadminServiceImpl();
		student s=stu.QueryStudentByID(teacherID);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("student", s);
		request.getRequestDispatcher("SystemAdmin/change_student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
