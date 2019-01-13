package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class ChapterAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String ChapterID = request.getParameter("ChapterID");
		// String ChapterID = new String(CID.getBytes("ISO8859_1"), "UTF-8");
//		System.out.println("章节ID:" + ChapterID);
		String ChapterName = request.getParameter("ChapterName");
//		System.out.println(ChapterName);
		// String ChapterName = new String(CName.getBytes("ISO8859_1"),
		// "UTF-8");
//		System.out.println("章节名:" + ChapterName);
		String courseselect = request.getParameter("courseselect");
		// courseselect = new String(courseselect.getBytes("ISO8859_1"),
		// "UTF-8");
//		System.out.println("课程名:" + courseselect);
		String box[] = request.getParameterValues("boxes");
//		for (int i = 0; i < box.length; i++) {
//			// box[i]=new String(box[i].getBytes("ISO8859_1"), "UTF-8");
//			System.out.print(box[i] + "\t");
//		}

		response.setContentType("text/html;charset=utf-8");

		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();

		QuestionTypeChapterService questionTypeChapterService = new QuestionTypeChapterServiceimpl();
		try {
			for (int i = 0; i < box.length; i++) {
				questionTypeChapter.setChapterID(ChapterID);
				questionTypeChapter.setChapterName(ChapterName);
				questionTypeChapter.setCourseID(courseselect);
				questionTypeChapter.setQuestionTypePronoun(box[i]);

				int r = questionTypeChapterService.addquestionchapter(questionTypeChapter);
				request.setAttribute("r", r);
			}
			//System.out.println();
			//System.out.println("集合大小" + questionTypeChapter);
			
			request.getRequestDispatcher("/ChapterinfoServlet?pageNum=1").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
