package com.oracle.service;

import java.util.List;

import com.oracle.daomain.QuestionsStylePronoun;

public interface QuestionTypeService {
    public List<QuestionsStylePronoun> QueryAllQuestionType();
    
    public QuestionsStylePronoun QueryQuestionTypeByPronoun(String pronoun);
    
    public boolean Add(QuestionsStylePronoun qs);
    
    public boolean DeleteByPronoun(String pronoun);
    
    public boolean UpdateByPronoun(String pronoun,QuestionsStylePronoun qs);
}
