package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Questions;
import com.oracle.service.QuestionsInfoService;
import com.oracle.service.impl.QuestionsInfoServiceImpl;

public class QuestionsAddServlet extends HttpServlet {
	private QuestionsInfoService questionsInfoService = new QuestionsInfoServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String courseID = request.getParameter("course_select");
		String chapterID = request.getParameter("chapter_select");
		String style = request.getParameter("question_type_select");
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
			int r=questionsInfoService.addquestions(questions);
			request.setAttribute("r", r);
			request.getRequestDispatcher("/QuestionsinfoServlet?pageNum=1").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
