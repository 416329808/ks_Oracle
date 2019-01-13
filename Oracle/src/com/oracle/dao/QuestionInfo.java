package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.PageBean;
import com.oracle.daomain.Questions;

public interface QuestionInfo {
	/**
	 * 查询所有章节题型
	 * 
	 * @return List<Questions>
	 * @throws SQLException 
	 */
	public List<Questions> findAllQuestions(String str ,int pageNum,int pageSize) throws SQLException;
	public List<Questions> findAllQuestionsWithPage(String str) throws SQLException;
	
	public List<Questions> findsomeQuestionsWithPage(Questions questions)throws SQLException;
	
	public List<Questions> findsomeQuestions(Questions questions ,int pageNum,int pageSize)throws SQLException;
	/**
	 * 查询单个章节题型
	 * 
	 * @return Questions
	 * @throws SQLException 
	 */
	public Questions findByID(Questions questions)throws SQLException;
	/**
	 * 添加章节题型
	 * 
	 * @param Questions
	 * @return
	 * @throws SQLException 
	 */
	public int addquestions(Questions questions) throws SQLException;
	
	
	/**
	 * 根据章节号和课程号删除章节
	 * 
	 * @param Questions
	 * @return
	 */
	public int deleteQuestionsByID(Questions questions)throws SQLException;
	
	
	/**
	 * 根据章节号和课程号修改章节
	 * 
	 * @param Questions
	 * @return
	 */
	public int updateQuestionsByID(Questions questions) throws SQLException;

}
