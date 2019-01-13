package com.oracle.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.CourseChapterQuestiondao;
import com.oracle.dao.CourseDao;
import com.oracle.dao.impl.CourseChapterQuestiondaoimpl;
import com.oracle.dao.impl.CourseDaoImpl;
import com.oracle.daomain.Chapter;
import com.oracle.daomain.Course;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.daomain.Questions;
import com.oracle.service.CourseChapterQuestionService;

public class CourseChapterQuestionServiceimpl implements CourseChapterQuestionService {

	private CourseChapterQuestiondao courseChapterQuestiondao=new CourseChapterQuestiondaoimpl();
	private CourseDao coursedao=new CourseDaoImpl();
	@Override
	public List<Chapter> FindChapterbyCourseID(Course course) throws SQLException {
		// TODO Auto-generated method stub
		return courseChapterQuestiondao.FindChapterbyCourseID(course);
	}

	@Override
	public List<QuestionTypeChapter> FindChapterbyChapterID(Chapter chapter) throws SQLException {
		// TODO Auto-generated method stub
		return courseChapterQuestiondao.FindChapterbyChapterID(chapter);
	}

	@Override
	public PageBean<Questions> FindQuestionbyAll(QuestionTypeChapter questionTypeChapter) throws SQLException {
		// TODO Auto-generated method stub
		return courseChapterQuestiondao.FindQuestionbyAll(questionTypeChapter);
	}

	@Override
	public List<Course> findCourses() throws SQLException {
		return coursedao.QueryAllCourse();
	}

}
