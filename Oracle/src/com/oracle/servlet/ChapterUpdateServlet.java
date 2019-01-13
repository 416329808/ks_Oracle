package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class ChapterUpdateServlet extends HttpServlet {
	QuestionTypeChapterService questionTypeChapterService = new QuestionTypeChapterServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String style = request.getParameter("style");
		System.out.println("style:"+style);
		if ("'add'".equals(style)) {
			add(request, response);
		}else{
			read(request, response);
		}
	
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//得到参数
		String ChapterID = request.getParameter("ChapterID");
		System.out.println(ChapterID);
		String ChapterName = request.getParameter("ChapterName");
		System.out.println(ChapterName);
		String CourseID = request.getParameter("courseselect");
		System.out.println("课程号"+CourseID);
		String box[] = request.getParameterValues("boxes");
		String ProblemNumber = request.getParameter("ProblemNumber");
		System.out.println(ProblemNumber);
		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
		//System.out.println(ChapterName);
		//封装成Javabean
		for (int i = 0; i < box.length; i++) {
			questionTypeChapter.setChapterID(ChapterID);
			questionTypeChapter.setChapterName(ChapterName);
			questionTypeChapter.setCourseID(CourseID);
			questionTypeChapter.setQuestionTypePronoun(box[i]);
			questionTypeChapter.setProblemNumber(ProblemNumber);
			try {
				
				int r = questionTypeChapterService.updatechapterByID(questionTypeChapter);
				request.setAttribute("r", r);
			} catch (Exception e) {

			}

		}
		
		request.setAttribute("questionTypeChapter", questionTypeChapter);
		request.getRequestDispatcher("/ChapterinfoServlet?pageNum=1").forward(request,response);
	}
    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
    	String ChapterID = request.getParameter("ChapterID");
		//System.out.println(ChapterID);
		String Meaning = request.getParameter("Meaning");
		//System.out.println(Meaning);
		String CourseID = request.getParameter("CourseID");
		//System.out.println(CourseID);
		String ChapterName = request.getParameter("ChapterName");
		//System.out.println(ChapterName);
		String ProblemNumber = request.getParameter("ProblemNumber").replaceAll("'", "");
		//System.out.println(ProblemNumber);
		
		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
		questionTypeChapter.setChapterID(ChapterID.replaceAll("'", ""));
		questionTypeChapter.setCourseID(CourseID.replaceAll("'", ""));
		questionTypeChapter.setMeaning(Meaning.replaceAll("'", ""));
		questionTypeChapter.setChapterName(ChapterName.replaceAll("'", ""));
		try {
			questionTypeChapter.setProblemNumber(ProblemNumber.equals(null)?"0":ProblemNumber);
		} catch (Exception e) {
		}
		System.out.println(questionTypeChapter);

		request.setAttribute("questionTypeChapter", questionTypeChapter);
		request.getRequestDispatcher("/AffairAdmin/change_chapter.jsp").forward(request,response);
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		doGet(request, response);
	}

}
