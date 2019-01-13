package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.paperNumdao;
import com.oracle.dao.impl.paperNumdaoImpl;
import com.oracle.service.change_passwordService;
import com.oracle.service.organize_paperService;
import com.oracle.service.impl.change_passwordServiceImpl;
import com.oracle.service.impl.organize_paperServiceImpl;

/**
 * Servlet implementation class oranize_paperServlet
 */
@WebServlet("/oranize_paperServlet")
public class oranize_paperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public oranize_paperServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	
		organize_paperService organize_paperService = new organize_paperServiceImpl();
		try {// 获取前台输入的各个题型数量
			System.out.println("组卷Servlet开始");
			int ChoiceQuestion = Integer.valueOf((String) request.getParameter("xuan")).intValue();
			System.out.println("组卷Servlet开始"+ChoiceQuestion);
			int TrueOrFalse = Integer.valueOf((String) request.getParameter("pan")).intValue();
			System.out.println("组卷Servlet开始"+TrueOrFalse);
			int FillInTheBlank = Integer.valueOf((String) request.getParameter("tian")).intValue();
			System.out.println("组卷Servlet开始"+FillInTheBlank);
			int CalculationProblems = Integer.valueOf((String) request.getParameter("ji")).intValue();
			System.out.println("组卷Servlet开始"+CalculationProblems);
			int ShortAnswerQuestion = Integer.valueOf((String) request.getParameter("jian")).intValue();
			System.out.println("组卷Servlet开始"+ShortAnswerQuestion);
			System.out.println("各个题型数量 " + ChoiceQuestion + "," + TrueOrFalse + "," + FillInTheBlank + ","
					+ ShortAnswerQuestion + "," + CalculationProblems);
			System.out.println("题型获取成功");
			request.getSession().setAttribute("ChoiceQuestion", ChoiceQuestion);
			request.getSession().setAttribute("TrueOrFalse", TrueOrFalse);
			request.getSession().setAttribute("FillInTheBlank", FillInTheBlank);
			request.getSession().setAttribute("ShortAnswerQuestion", ShortAnswerQuestion);
			request.getSession().setAttribute("CalculationProblems", CalculationProblems);
			int paperNum=organize_paperService.createpaper(ChoiceQuestion, TrueOrFalse, FillInTheBlank, ShortAnswerQuestion,
					CalculationProblems);
			System.out.println("组卷成功");
			String message = "组卷成功";
			request.setAttribute("message", message);
			response.sendRedirect("paperServlet?paperNum=" + paperNum + "&message=" + message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
