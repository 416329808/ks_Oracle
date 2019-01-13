package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.daomain.question;
import com.oracle.service.paperService;
import com.oracle.service.impl.paperServiceImpl;

/**
 * Servlet implementation class paperServlet
 */
@WebServlet("/paperServlet")
public class paperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我被执行了");
		// 获取用户输入的账户
		String paperNum = request.getParameter("paperNum");
		if(paperNum==null)
		{
			paperNum=request.getParameter("Chapter_paper_select");
		}
		System.out.println(paperNum);
		paperService paperService=new paperServiceImpl();
			List<List<question>> List = null;
			try {
				List = paperService.Login(paperNum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list",List);
			request.setAttribute("paperNum",paperNum);
			request.getRequestDispatcher("/Student/test_online.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
