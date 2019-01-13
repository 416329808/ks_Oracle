package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.daomain.Questions;

public interface QuestionTypeChapterinfo {
	/**
	 * 查询所有章节题型
	 * 
	 * @return List<QuestionTypeChapter>
	 * @throws SQLException 
	 */
	public List<QuestionTypeChapter> findAllQuestionTypeChapter(int pageNum,int pageSize) throws SQLException;
	public List<QuestionTypeChapter> findAllQuestionTypeChapter() throws SQLException;
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
	 * @param QuestionTypeChapter
	 * @return
	 */
	public int deletechapterByID(QuestionTypeChapter questionTypeChapter)throws SQLException;
	
	
	/**
	 * 根据章节号和课程号修改章节
	 * 
	 * @param QuestionTypeChapter
	 * @return
	 */
	public int updatechapterByID(QuestionTypeChapter questionTypeChapter) throws SQLException;

}
