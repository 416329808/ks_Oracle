package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.question;
import com.oracle.daomain.Course;
import com.oracle.daomain.QuestionType_Chapter;
import com.oracle.daomain.Chapter;
public interface questiondao {
	public List<Course> course()throws SQLException;
	//所有课程
	public String Chapter(String CourseID)throws SQLException;
	//ID课程下所有章节
	public List<QuestionType_Chapter> QuestionType_Chapter(String CourseID,String ChapterID)throws SQLException;
	//章节下所有题型
	public List<question> allQuestion(String CourseID,String Chapter,String Type,String name)throws SQLException;


}
