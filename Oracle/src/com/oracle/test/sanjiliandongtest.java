package com.oracle.test;

import java.sql.SQLException;

import org.junit.Test;

import com.oracle.dao.QuestionInfo;
import com.oracle.dao.impl.QuestionsInfoImpl;
import com.oracle.daomain.*;
import com.oracle.service.CourseChapterQuestionService;
import com.oracle.service.QuestionsInfoService;
import com.oracle.service.impl.CourseChapterQuestionServiceimpl;
import com.oracle.service.impl.QuestionsInfoServiceImpl;

public class sanjiliandongtest {
	private QuestionInfo courseChapterQuestionService=new QuestionsInfoImpl();   
	@Test
	public void testcourse() throws SQLException {
		String courseIdString="1104201506";
		String chapterID="1";
		String styleString="4";
		Questions course=new Questions();
		course.setCourseID(courseIdString);
		course.setChapterID(chapterID);
		course.setStyle(styleString);
		courseChapterQuestionService.findsomeQuestionsWithPage(course);
	}
}
