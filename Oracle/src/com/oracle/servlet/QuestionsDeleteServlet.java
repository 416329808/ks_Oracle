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

public class QuestionsDeleteServlet extends HttpServlet {
	private QuestionsInfoService questionsInfoService = new QuestionsInfoServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String questionsID=request.getParameter("ID");
		String style=request.getParameter("style");
		Questions questions = new Questions(); 
		questions.setQuestionsID(questionsID);
		questions.setStyle(style);
		try {
			int r=questionsInfoService.deleteQuestionsByID(questions);
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
