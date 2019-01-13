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
 * Servlet implementation class AddQuestionTypeServlet
 */
//@WebServlet("/AddQuestionTypeServlet")
public class AddQuestionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(1);
		request.setCharacterEncoding("utf-8");
		String Pronoun=request.getParameter("Pronoun");
		System.out.println(Pronoun);
	    String Meaning=request.getParameter("Meaning");
	    QuestionTypeServiceImpl qts=new QuestionTypeServiceImpl();
	    QuestionsStylePronoun qsp=new QuestionsStylePronoun(Pronoun,Meaning);
	    response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    boolean b=qts.Add(qsp);
	    if(b) System.out.println("Pronoun:"+Pronoun+"添加成功");
	    else System.out.println("Pronoun:"+Pronoun+"添加失败");
	    request.getRequestDispatcher("QueryAllQuestionTypeServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
