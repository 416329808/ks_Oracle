package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Course;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.Questions;
import com.oracle.service.CourseChapterQuestionService;
import com.oracle.service.QuestionsInfoService;
import com.oracle.service.impl.CourseChapterQuestionServiceimpl;
import com.oracle.service.impl.QuestionsInfoServiceImpl;

public class QuestionsinfoServlet extends HttpServlet {
	private QuestionsInfoService questionsInfoService = new QuestionsInfoServiceImpl();
	 private CourseChapterQuestionService courseChapterQuestionService=new CourseChapterQuestionServiceimpl();   
	List<Questions> questionsinfolist;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String style = request.getParameter("Style");
		if (style==null||style.equals(null)||style=="") {
			allinfo(request, response);
		}else if("change".equals(style)){
			someinfo(request,response);
		}else {
			deatilinfo(request, response);
		}

	}
	public void allinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String str = request.getParameter("choice");
		//System.out.println(str);
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int pageSize=10;
		PageBean<Questions> pb;
		try {
			
			pb = questionsInfoService.findAllQuestionsWithPage(str,pageNum, pageSize);
			List<Course> courses=courseChapterQuestionService.findCourses();
			request.setAttribute("pb", pb);
			request.setAttribute("tCdCarBrandList", courses);
			request.getRequestDispatcher("/AffairAdmin/question_admin.jsp").forward(request, response);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void deatilinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String style = request.getParameter("Style");
		String questionsID = request.getParameter("questionID");
		Questions questions = new Questions(); 
		questions.setStyle(style);
		questions.setQuestionsID(questionsID);
		//System.out.println(questions);
		Questions questions2 = null;
		try {
			questions2=questionsInfoService.findByID(questions);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("questions2", questions2);
		if ("1".equals(style)) {
			request.getRequestDispatcher("/AffairAdmin/details_choices.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/AffairAdmin/details_other.jsp").forward(request, response);
		}

	}
	public void someinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int pageSize=10;
		System.out.println(pageNum);
		String courseId = request.getParameter("courseId");
		String chapterId = request.getParameter("chapterId");
		String questiontype =request.getParameter("questiontype");
		Questions questions=new Questions();
		questions.setCourseID(courseId);
		questions.setChapterID(chapterId);
		questions.setStyle(questiontype);
		PageBean<Questions> pb=null;
		try {
			pb = questionsInfoService.findsomeQuestions(questions, pageNum, pageSize);
			List<Course> courses=courseChapterQuestionService.findCourses();
			request.setAttribute("pb", pb);
			request.setAttribute("tCdCarBrandList", courses);
			request.getRequestDispatcher("/AffairAdmin/question_admin.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("zhongdianzai zheli"+pb.getList());


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
