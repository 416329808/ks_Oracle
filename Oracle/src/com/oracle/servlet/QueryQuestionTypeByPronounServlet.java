package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.QuestionsStylePronoun;
import com.oracle.service.impl.QuestionTypeServiceImpl;

/**
 * Servlet implementation class QueryQuestionTypeByPronounServlet
 */
@WebServlet("/QueryQuestionTypeByPronounServlet")
public class QueryQuestionTypeByPronounServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryQuestionTypeByPronounServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String Pronoun=request.getParameter("Pronoun");
		QuestionTypeServiceImpl qts=new QuestionTypeServiceImpl();
		QuestionsStylePronoun qsp=qts.QueryQuestionTypeByPronoun(Pronoun);
		request.setAttribute("QuestionsStylePronoun", qsp);
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("AffairAdmin/change_question_type.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
