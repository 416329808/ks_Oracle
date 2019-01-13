package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public QueryAllStudentServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");

        StudentadminService stu=new StudentadminServiceImpl();
		List<student> students=stu.QueryAllStudent();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//System.out.println("servlet"+students);
		request.setAttribute("students", students);
		request.getRequestDispatcher("SystemAdmin/student_admin.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
