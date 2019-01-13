package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.impl.QuestionTypeDaoImpl;
import com.oracle.daomain.QuestionsStylePronoun;
import com.oracle.service.QuestionTypeService;

public class QuestionTypeServiceImpl implements QuestionTypeService{
     
	QuestionTypeDaoImpl qtd=new QuestionTypeDaoImpl();
	@Override
	public List<QuestionsStylePronoun> QueryAllQuestionType() {
		// TODO 自动生成的方法存根
		return qtd.QueryAllQuestionType();
	}

	@Override
	public QuestionsStylePronoun QueryQuestionTypeByPronoun(String pronoun) {
		// TODO 自动生成的方法存根
		return qtd.QueryQuestionTypeByPronoun(pronoun);
	}

	@Override
	public boolean Add(QuestionsStylePronoun qs) {
		// TODO 自动生成的方法存根
		if(!(qtd.IsExist(qs.getPronoun()))) return qtd.Add(qs);
		else return false;
	}

	@Override
	public boolean DeleteByPronoun(String pronoun) {
		// TODO 自动生成的方法存根
		if(qtd.IsExist(pronoun)) return qtd.DeleteByPronoun(pronoun);
		else return false;
	}

	@Override
	public boolean UpdateByPronoun(String pronoun, QuestionsStylePronoun qs) {
		// TODO 自动生成的方法存根
		if(qtd.IsExist(pronoun)) return qtd.UpdateByPronoun(pronoun, qs);
		else return false;
	}

}
