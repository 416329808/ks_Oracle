package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class ChapterinfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PageBean<QuestionTypeChapter> pb;
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int pageSize=10;
		QuestionTypeChapterService questionTypeChapterService=new QuestionTypeChapterServiceimpl();
		try {
			pb=questionTypeChapterService.findAllQuestionTypeChapter(pageNum, pageSize);

			request.setAttribute("pb", pb);
		    request.getRequestDispatcher("/AffairAdmin/chapter_admin.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
