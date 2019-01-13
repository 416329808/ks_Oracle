package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.impl.TeacherServiceImpl;


@WebServlet("/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteTeacherServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String TeacherID=request.getParameter("TeacherID");
		TeacherServiceImpl ts=new TeacherServiceImpl();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if(ts.DeleteTeacherByID(TeacherID)) System.out.println("teacherID:"+TeacherID+"删除成功");
		else System.out.println("teacherID:"+TeacherID+"删除失败");
		request.getRequestDispatcher("QueryAllTeacherServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
