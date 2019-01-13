package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;

public interface QuestionTypeChapterService {
	/**
	 * 查询所有章节题型
	 * 
	 * @return List<QuestionTypeChapter>
	 * @throws SQLException 
	 */
	public PageBean<QuestionTypeChapter> findAllQuestionTypeChapter(int pageNum,int pageSize) throws SQLException;
	/**
	 * 查询单个章节题型
	 * 
	 * @return QuestionTypeChapter
	 * @throws SQLException 
	 */
	public QuestionTypeChapter findByID(QuestionTypeChapter questionTypeChapter)throws SQLException;
	
	
	/**
	 * 添加章节题型
	 * 
	 * @param QuestionTypeChapter
	 * @return
	 * @throws SQLException 
	 */
	public int addquestionchapter(QuestionTypeChapter questionTypeChapter) throws SQLException;
	
	
	/**
	 * 根据章节号和课程号删除章节
	 * 
	 * @param QuestionTypeChapter questionTypeChapter
	 * @return
	 */
	public int deletechapterByID(QuestionTypeChapter questionTypeChapter)throws SQLException;
	
	
	/**
	 * 根据章节号和课程号修改章节
	 * 
	 * @param QuestionTypeChapter questionTypeChapter
	 * @return
	 */
	public int updatechapterByID(QuestionTypeChapter questionTypeChapter)throws SQLException;



}
