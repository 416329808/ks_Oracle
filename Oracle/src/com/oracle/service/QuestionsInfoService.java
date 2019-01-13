package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.PageBean;
import com.oracle.daomain.Questions;

public interface QuestionsInfoService {
	/**
	 * 查询所有章节题型
	 * 
	 * @return PageBean<Questions>
	 * @throws SQLException 
	 */
	public PageBean<Questions> findAllQuestionsWithPage(String str ,int pageNum,int pageSize) throws SQLException;
	
	
	public PageBean<Questions> findsomeQuestions(Questions questions,int pageNum,int pageSize)throws SQLException;
	
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
