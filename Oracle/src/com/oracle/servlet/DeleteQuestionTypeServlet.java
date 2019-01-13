package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.impl.QuestionTypeServiceImpl;

/**
 * Servlet implementation class DeleteQuestionTypeServlet
 */
@WebServlet("/DeleteQuestionTypeServlet")
public class DeleteQuestionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		QuestionTypeServiceImpl qts=new QuestionTypeServiceImpl();
	    String Pronoun=request.getParameter("Pronoun");
		boolean b=qts.DeleteByPronoun(Pronoun);
		if(b) System.out.println("Pronoun："+Pronoun+"删除成功");
		else System.out.println("Pronoun："+Pronoun+"删除失败");
		response.sendRedirect("QueryAllQuestionTypeServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
