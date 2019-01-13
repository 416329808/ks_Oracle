package com.oracle.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Course;
import com.oracle.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class QueryAllServlet
 */
@WebServlet("/QueryAllCourseServlet")
public class QueryAllCourseServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1303067980536651678L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		CourseServiceImpl csi=new CourseServiceImpl();
		List<Course> courses=new ArrayList<>();
		courses=csi.QueryAllCourse();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("AffairAdmin/course_admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
