package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.student;
import com.oracle.service.studentService;
import com.oracle.service.impl.studentServiceImpl;


@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentInfoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("woshimaodalao!");
		 String ID=request.getParameter("ID");
		 
		 String msg=(String) request.getParameter("message");
		 System.out.println("msg"+msg);
		 //System.out.println(ID);
		    studentService studentService=new studentServiceImpl();
		    student student;
			try {
				student = studentService.findstudent(ID);
				//System.out.println("这个学生是水水水水水 "+student);
				request.setAttribute("student", student);
				request.setAttribute("message",msg);
			    request.getRequestDispatcher("/Student/individual_info.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
