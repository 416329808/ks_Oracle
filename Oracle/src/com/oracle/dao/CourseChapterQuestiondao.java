package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.Course;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.daomain.Questions;
import com.oracle.daomain.Chapter;

public interface CourseChapterQuestiondao {
	public List<Chapter> FindChapterbyCourseID(Course course) throws SQLException;
	
	
	public List<QuestionTypeChapter> FindChapterbyChapterID(Chapter chapter) throws SQLException;
	
	
	public PageBean<Questions> FindQuestionbyAll(QuestionTypeChapter questionTypeChapter) throws SQLException;
}
