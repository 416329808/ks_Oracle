package com.oracle.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.QuestionInfo;
import com.oracle.dao.impl.QuestionsInfoImpl;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.Questions;
import com.oracle.service.QuestionsInfoService;

public class QuestionsInfoServiceImpl implements QuestionsInfoService {
	private QuestionInfo questionsInfo= new QuestionsInfoImpl();
	public QuestionsInfoServiceImpl() {
	
	}

	@Override
	public Questions findByID(Questions questions) throws SQLException {
		
		return questionsInfo.findByID(questions);
	}

	@Override
	public int addquestions(Questions questions) throws SQLException {
		
		return questionsInfo.addquestions(questions);
	}

	@Override
	public int deleteQuestionsByID(Questions questions) throws SQLException {
	
		return questionsInfo.deleteQuestionsByID(questions);
	}

	@Override
	public int updateQuestionsByID(Questions questions) throws SQLException {
		
		return questionsInfo.updateQuestionsByID(questions);
	}


	@Override
	public PageBean<Questions> findAllQuestionsWithPage(String str ,int pageNum,int pageSize) throws SQLException {
		List<Questions> Userinfos= questionsInfo.findAllQuestionsWithPage(str);
		int totalRecord=Userinfos.size();
		PageBean<Questions> pb= new PageBean<Questions>(pageNum, pageSize, totalRecord);
		int startIndex=pb.getPageNum();
		pb.setList(questionsInfo.findAllQuestions(str, startIndex,pageSize));
		return pb;
	}

	@Override
	public PageBean<Questions> findsomeQuestions(Questions questions ,int pageNum,int pageSize) throws SQLException {
		List<Questions> Userinfos= questionsInfo.findsomeQuestionsWithPage(questions);
		int totalRecord=Userinfos.size();
		System.out.println("总数"+totalRecord);
		PageBean<Questions> pb= new PageBean<Questions>(pageNum, pageSize, totalRecord);
		int startIndex=pb.getPageNum();
		pb.setList(questionsInfo.findsomeQuestions(questions, startIndex,pageSize));
		return pb;
	}

}
