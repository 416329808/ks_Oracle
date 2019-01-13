package com.oracle.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.QuestionTypeChapterinfo;
import com.oracle.dao.impl.QuestionTypeChapterinfoimpl;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.service.QuestionTypeChapterService;

public class QuestionTypeChapterServiceimpl implements QuestionTypeChapterService {
	private QuestionTypeChapterinfo questiontypechapternfo = new  QuestionTypeChapterinfoimpl(); 

	@Override
	public PageBean<QuestionTypeChapter> findAllQuestionTypeChapter(int pageNum,int pageSize) throws SQLException {
		
		List<QuestionTypeChapter> Userinfos= questiontypechapternfo.findAllQuestionTypeChapter();
		int totalRecord=Userinfos.size();
		PageBean<QuestionTypeChapter> pb= new PageBean<QuestionTypeChapter>(pageNum, pageSize, totalRecord);
		int startIndex=pb.getPageNum();
		pb.setList(questiontypechapternfo.findAllQuestionTypeChapter(startIndex,pageSize));
		return pb;
	}

	@Override
	public int addquestionchapter(QuestionTypeChapter questionTypeChapter) throws SQLException {
		
		return questiontypechapternfo.addquestionchapter(questionTypeChapter);
	}

	@Override
	public int deletechapterByID(QuestionTypeChapter questionTypeChapter) throws SQLException {
		
		return questiontypechapternfo.deletechapterByID(questionTypeChapter);
	}

	@Override
	public int updatechapterByID(QuestionTypeChapter questionTypeChapter) throws SQLException {
		
		return questiontypechapternfo.updatechapterByID(questionTypeChapter);
	}

	@Override
	public QuestionTypeChapter findByID(QuestionTypeChapter questionTypeChapter) throws SQLException {

		return questiontypechapternfo.findByID(questionTypeChapter);
	}


}
