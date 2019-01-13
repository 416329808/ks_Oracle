package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.QuestionsStylePronoun;
import com.oracle.service.impl.QuestionTypeServiceImpl;

@WebServlet("/questionTypeUpdateServlet")
public class questionTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public questionTypeUpdateServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String Pronoun=request.getParameter("Pronoun");
		String Meaning=request.getParameter("Meaning");
		System.out.println("修改过来了啊啊啊啊啊啊"+Pronoun+Meaning);
		QuestionsStylePronoun qs=new QuestionsStylePronoun(Pronoun, Meaning);
		QuestionTypeServiceImpl qts=new QuestionTypeServiceImpl();
		boolean rs=qts.UpdateByPronoun(Pronoun, qs);
		System.out.println(rs);
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("QueryAllQuestionTypeServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
