package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class ChapterdeleteServlet extends HttpServlet {

	QuestionTypeChapterService questionTypeChapterService = new QuestionTypeChapterServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ChapterID = request.getParameter("ChapterID");
		System.out.println(ChapterID);
		String Meaning = request.getParameter("Meaning");
		System.out.println(Meaning);
		String CourseID = request.getParameter("CourseID");
		System.out.println(CourseID);
		int r=0;
		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
		questionTypeChapter.setChapterID(ChapterID);
		questionTypeChapter.setCourseID(CourseID);
		questionTypeChapter.setMeaning(Meaning);
		try {
	
			//System.out.println(questionTypeChapter);
			r=questionTypeChapterService.deletechapterByID(questionTypeChapter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("r", r);
		request.getRequestDispatcher("/ChapterinfoServlet?pageNum=1").forward(request,response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
