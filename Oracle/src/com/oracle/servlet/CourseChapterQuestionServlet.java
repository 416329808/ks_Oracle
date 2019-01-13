package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Chapter;
import com.oracle.daomain.Course;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.CourseChapterQuestionService;
import com.oracle.service.impl.CourseChapterQuestionServiceimpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CourseChapterQuestionServlet
 */
@WebServlet("/CourseChapterQuestionServlet")
public class CourseChapterQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseChapterQuestionService courseChapterQuestionService=new CourseChapterQuestionServiceimpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseChapterQuestionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String style = request.getParameter("style");
		System.out.println(style);
		if ("questionstyle".equals(style)) {
			questionstyle(request, response);
		}else if("chapter".equals(style)){
			try {
				chapter(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private void chapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String courseId = request.getParameter("brandId");
		//System.out.println("qiankechengid"+courseId);
		Course course=new Course();
		course.setCourseID(courseId);
		//System.out.println("qian课程id"+course);
	
		List<Chapter> courselist=courseChapterQuestionService.FindChapterbyCourseID(course);
		//System.out.println("idchapter:"+courselist.get(0).getChapterID());
		PrintWriter out = null;
		JSONArray mlist = JSONArray.fromObject(courselist); //有依赖jar包
		try {
			out = response.getWriter();
			out.print(mlist.toString());			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

	}

	private void questionstyle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId = request.getParameter("brandId");
		System.out.println("ticourseid:"+courseId);
		String chapterId = request.getParameter("branchId");
		System.out.println("tichapterid:"+chapterId);
		Chapter chapter=new Chapter();
		chapter.setCourseID(courseId);
		chapter.setChapterID(chapterId);
		System.out.println("章节课程:"+chapter);
		try {
			List<QuestionTypeChapter> chapterlist=courseChapterQuestionService.FindChapterbyChapterID(chapter);
			request.setAttribute("tCdCarModelList", chapterlist);
			//System.out.println(chapterlist);
			PrintWriter out = null;
			JSONArray mlist = JSONArray.fromObject(chapterlist); //有依赖jar包
			try {
				out = response.getWriter();
				out.print(mlist.toString());			
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
