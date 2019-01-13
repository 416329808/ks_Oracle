package com.oracle.dao;

import java.sql.SQLException;


public interface organize_paperdao {
	//创建一张新试卷
	public int createpaper(int ChoiceQuestion,int TrueOrFalse,int FillInTheBlank,int ShortAnswerQuestion,int CalculationProblems)throws SQLException;
 
}
