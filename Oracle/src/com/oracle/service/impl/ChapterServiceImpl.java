package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.questiondao;
import com.oracle.dao.impl.questiondaoimpl;
import com.oracle.daomain.question;
import com.oracle.service.ChapterService;
import com.oracle.service.CourseService;

public class ChapterServiceImpl implements ChapterService{

	@Override
	public String GetChapter(String CourseID) throws SQLException {
		// TODO Auto-generated method stub
		questiondao dao=new questiondaoimpl();
		System.out.println("章节Service"+CourseID);
		String Chapter=dao.Chapter(CourseID);
		System.out.println("章节数"+Chapter);
		return Chapter;
	}

}
