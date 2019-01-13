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
 * Servlet implementation class UpdateQuestionTypeServlet
 */
@WebServlet("/UpdateQuestionTypeServlet")
public class UpdateQuestionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionTypeServlet() {
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
		String Meaning=request.getParameter("Meaning");
		QuestionTypeServiceImpl qts=new QuestionTypeServiceImpl();
		QuestionsStylePronoun qsp=new QuestionsStylePronoun(Pronoun,Meaning);
		boolean b=qts.UpdateByPronoun(Pronoun, qsp);
		String flag=null;
		if(b) {
			System.out.println("Pronoun:"+Pronoun+"修改成功");
			flag="yes";
		}
		else {
			System.out.println("Pronoun:"+Pronoun+"修改失败");
			flag="no";
		}
		request.setAttribute("flag", flag);
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
