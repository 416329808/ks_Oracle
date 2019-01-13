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
import com.oracle.service.CourseService;
import com.oracle.service.questionService;
import com.oracle.service.impl.CourseServiceImpl;
import com.oracle.service.impl.questionServiceImpl;

/**
 * Servlet implementation class SerchQuestionServlet
 */
@WebServlet("/SerchQuestionServlet")
public class SerchQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerchQuestionServlet() {// 查询完整题目
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("题目servlet!");
		CourseService CourseService=new CourseServiceImpl();//实例化课程
		//ChapterService ChapterService=new ChapterServiceImpl();//实例化章节
		    List<Course> Course=null;
		    String CourseID="";
		    String Chapter="";
		    String Type="";
		    //String Chapter="";
			try {
				Course = CourseService.GetCourse();
				CourseID = request.getParameter("Course_type_select");
				Chapter = request.getParameter("Chapter_type_select");
				Type = request.getParameter("Type_type_select");
				//Chapter=ChapterService.GetChapter(CourseID);
				//request.setAttribute("Chapter", Chapter);
				request.setAttribute("Course",Course);
			    //request.getRequestDispatcher("/Student/search_question.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = request.getParameter("teaName");
			System.out.println("获取值aaa"+CourseID+Chapter+Type+name);
			List<question> Qlist = null;
			questionService QS = new questionServiceImpl();
			try {
				Qlist=QS.getpassword(CourseID, Chapter, Type, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Qlist",Qlist);
			request.setAttribute("CourseID",CourseID);
			request.setAttribute("Chapter",Chapter);
			request.setAttribute("Type",Type);
			//question Q1=Qlist.get(0);
			//System.out.println("第一题题目"+Q1.getTopics());
		    request.getRequestDispatcher("/Student/search_question.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
