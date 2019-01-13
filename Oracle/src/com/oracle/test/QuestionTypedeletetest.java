package com.oracle.test;

import java.sql.SQLException;

import org.junit.Test;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class QuestionTypedeletetest {
	QuestionTypeChapterService questionTypeChapterService = new QuestionTypeChapterServiceimpl();
	public QuestionTypedeletetest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void delete() throws SQLException{
		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
		questionTypeChapter.setChapterID("6");
		questionTypeChapter.setCourseID("1104201509");
		questionTypeChapter.setMeaning("计算题");
		try {
			System.out.println(questionTypeChapter);
			int r=questionTypeChapterService.deletechapterByID(questionTypeChapter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
//		questionTypeChapter.setMeaning("判断题");
//		questionTypeChapter.setChapterID("6");
//		questionTypeChapter.setCourseID("1104201507");
//		int r=questionTypeChapterService.deletechapterByID(questionTypeChapter);
	}
	@Test
	public void add() throws SQLException{
		QuestionTypeChapter questionTypeChapter = new QuestionTypeChapter();
		questionTypeChapter.setProblemNumber("'5'");
		questionTypeChapter.setChapterID("'4'");
		questionTypeChapter.setChapterName("'第四章'");
		questionTypeChapter.setMeaning("'选择题'");
		questionTypeChapter.setCourseID("'1104201506'");
		int r=questionTypeChapterService.updatechapterByID(questionTypeChapter);
	}

}
