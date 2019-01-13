package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.StudentadminService;
import com.oracle.service.impl.StudentadminServiceImpl;
import com.oracle.service.impl.TeacherServiceImpl;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String StudentID = request.getParameter("StudentID");

		StudentadminService stu = new StudentadminServiceImpl();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (stu.DeleteStudentByID(StudentID))
			System.out.println("teacherID:" + StudentID + "删除成功");
		else
			System.out.println("teacherID:" + StudentID + "删除失败");
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
