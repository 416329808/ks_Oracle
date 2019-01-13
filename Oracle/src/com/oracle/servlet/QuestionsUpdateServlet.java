package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Questions;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.QuestionsInfoService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;
import com.oracle.service.impl.QuestionsInfoServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class QuestionsUpdateServlet extends HttpServlet {
	QuestionsInfoService questionsInfoService = new QuestionsInfoServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opertion = request.getParameter("opertion");
		System.out.println("opertion:"+opertion);
		if ("add".equals(opertion)) {
			add(request, response);
		}else{
			read(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r;
		String questionsID=request.getParameter("ID");
		String courseID = request.getParameter("course_select");
		String chapterID = request.getParameter("chapter_select");
		String style = request.getParameter("style");
		String score = request.getParameter("score");
		String difficult = request.getParameter("difficult");
		String businessadminsid = request.getParameter("businessadminsid");
		String topics = request.getParameter("topic");
		String optionA = request.getParameter("inputA");
		String optionB = request.getParameter("inputB");
		String optionC = request.getParameter("inputC");
		String optionD = request.getParameter("inputD");
		String answer = request.getParameter("answer");
		String analysiss = request.getParameter("analysiss");
		Questions questions = new Questions(); 
		questions.setStyle(style);
		questions.setQuestionsID(questionsID);
		questions.setCourseID(courseID);
		questions.setChapterID(chapterID);
		questions.setScore(score);
		questions.setDifficult(difficult);
		questions.setTopics(topics);
		questions.setReporterID(businessadminsid);
		questions.setOptionA(optionA);
		questions.setOptionB(optionB);
		questions.setOptionC(optionC);
		questions.setOptionD(optionD);
		questions.setAnswer(answer);
		questions.setAnalysiss(analysiss);
		System.out.println(questions);
		try {
			r = questionsInfoService.updateQuestionsByID(questions);
			request.setAttribute("r", r);
			request.getRequestDispatcher("/QuestionsinfoServlet?pageNum=1").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		String courseID = request.getParameter("course_select");
		String chapterID = request.getParameter("chapter_select");
		String style = request.getParameter("style");
		String questionid = request.getParameter("ID");
		System.out.println(questionid);
		Questions questions = new Questions(); 
		questions.setStyle(style);
		questions.setQuestionsID(questionid);
		try {
			questions=questionsInfoService.findByID(questions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(questions);
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("/AffairAdmin/change_question.jsp").forward(request,response);
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
