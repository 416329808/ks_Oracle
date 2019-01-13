package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Course;
import com.oracle.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class QueryCourseByIdServlet
 */
@WebServlet("/QueryCourseByIdServlet")
public class QueryCourseByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCourseByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String CourseID=request.getParameter("CourseID");
		CourseServiceImpl csi=new CourseServiceImpl();
		Course course=csi.QueryById(CourseID);
		request.setAttribute("course", course);
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("AffairAdmin/change_course.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
