package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Course;
import com.oracle.daomain.question;
import com.oracle.daomain.student;
import com.oracle.service.ChapterService;
import com.oracle.service.CourseService;
import com.oracle.service.LoginService;
import com.oracle.service.questionService;
import com.oracle.service.studentService;
import com.oracle.service.impl.ChapterServiceImpl;
import com.oracle.service.impl.CourseServiceImpl;
import com.oracle.service.impl.LoginServiceImpl;
import com.oracle.service.impl.questionServiceImpl;
import com.oracle.service.impl.studentServiceImpl;

/**
 * Servlet implementation class questionServlet
 */
@WebServlet("/questionServlet")
public class questionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private CourseService courseservice= new CourseServiceImpl();
    public questionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("题目servlet!");
		CourseService CourseService=new CourseServiceImpl();//实例化课程
		//ChapterService ChapterService=new ChapterServiceImpl();//实例化章节
		    List<Course> Course=null;
		    String CourseID="";
		    //String Chapter="";
			try {
				Course = CourseService.GetCourse();
				CourseID = request.getParameter("Course_type_select");
				request.setAttribute("Course",Course);
			    //request.getRequestDispatcher("/Student/search_question.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String CourseID1 ="%";
			String Chapter ="%";
			String Type ="%";
			String name ="%";
			List<question> Qlist = null;
			questionService QS = new questionServiceImpl();
			try {
				Qlist=QS.getpassword(CourseID1, Chapter, Type, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Qlist",Qlist);
			question Q1=Qlist.get(0);
			System.out.println("第一题题目"+Q1.getTopics());
		    request.getRequestDispatcher("/Student/search_question.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
