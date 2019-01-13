package com.oracle.test;

import java.sql.SQLException;

import org.junit.Test;

import com.oracle.daomain.Questions;
import com.oracle.service.QuestionsInfoService;
import com.oracle.service.impl.QuestionsInfoServiceImpl;

public class Questionsinfotest {
	private QuestionsInfoService questionsInfoService= new QuestionsInfoServiceImpl();
	public Questionsinfotest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void info() throws SQLException{
		Questions questions = new Questions(); 
		questions.setStyle("1");
		questions.setQuestionsID("1");
		System.out.println(questions);
		questions=questionsInfoService.findByID(questions);

	}

}
