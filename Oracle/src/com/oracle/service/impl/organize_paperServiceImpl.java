package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.logindao;
import com.oracle.dao.organize_paperdao;
import com.oracle.dao.impl.logindaoImpl;
import com.oracle.dao.impl.organize_paperdaoImpl;
import com.oracle.daomain.checkperson;
import com.oracle.service.organize_paperService;

public class organize_paperServiceImpl implements organize_paperService{

	@Override
	public int createpaper(int ChoiceQuestion, int TrueOrFalse, int FillInTheBlank, int ShortAnswerQuestion,
			int CalculationProblems) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("组卷Service开始");
		organize_paperdao dao  =new organize_paperdaoImpl();
	    int list=dao.createpaper(ChoiceQuestion, TrueOrFalse, FillInTheBlank, ShortAnswerQuestion, CalculationProblems);
		return list;
	}

}
