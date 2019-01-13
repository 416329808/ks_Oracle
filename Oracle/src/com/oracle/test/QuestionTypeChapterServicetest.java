package com.oracle.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;
import com.oracle.service.impl.QuestionTypeChapterServiceimpl;

public class QuestionTypeChapterServicetest {
	private QuestionTypeChapterService questionTypeChapterService = new QuestionTypeChapterServiceimpl();

	@Test
	public void QuestionTypeChapterServicetest() throws SQLException{
		
//		QuestionTypeChapter questionTypeChapter= new QuestionTypeChapter(); 
//		questionTypeChapter.setChapterID("6");
//		questionTypeChapter.setChapterName("第六章");
//		questionTypeChapter.setMeaning("选择题");
//		questionTypeChapter.setCourseID("1104201508");
//		questionTypeChapterService.addchapter(questionTypeChapter);
		List<QuestionTypeChapter> questionTypeChapter = new ArrayList<QuestionTypeChapter>(5);
		QuestionTypeChapter questionTypeChapter2[]= new QuestionTypeChapter[5];
		for (int i = 0; i < questionTypeChapter2.length; i++) {
			questionTypeChapter.add(questionTypeChapter2[i]);
		}
		System.out.println(questionTypeChapter.size());
	}

}
