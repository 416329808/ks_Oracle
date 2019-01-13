package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Teacher;
import com.oracle.daomain.student;
import com.oracle.service.TeacherService;
import com.oracle.service.studentService;
import com.oracle.service.impl.TeacherServiceImpl;
import com.oracle.service.impl.studentServiceImpl;


@WebServlet("/TeacherInfoServlet")
public class TeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeacherInfoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String ID=request.getParameter("ID");
		
		
		    TeacherService TeacherService=new TeacherServiceImpl();
		    Teacher Teacher;
			try {
				Teacher = TeacherService.QueryTeacherByID(ID);
				
				request.setAttribute("Teacher", Teacher);
				
			    request.getRequestDispatcher("/Teacher/individual_info.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
