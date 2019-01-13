package com.oracle.service;

import java.sql.SQLException;

public interface organize_paperService {

	public int createpaper(int ChoiceQuestion,int TrueOrFalse,int FillInTheBlank,int ShortAnswerQuestion,int CalculationProblems)throws SQLException;
}
