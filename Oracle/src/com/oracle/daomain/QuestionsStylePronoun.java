package com.oracle.daomain;

public class QuestionsStylePronoun {
	//试题id
    String Pronoun;
    //题型
    String Meaning;
    //试题数
    int QuestionsNum;
	public QuestionsStylePronoun(String pronoun, String meaning, int questionsNum) {
		Pronoun = pronoun;
		Meaning = meaning;
		QuestionsNum = questionsNum;
	}
	public QuestionsStylePronoun(String pronoun, String meaning) {
		super();
		Pronoun = pronoun;
		Meaning = meaning;
	}
	public String getPronoun() {
		return Pronoun;
	}
	public void setPronoun(String pronoun) {
		Pronoun = pronoun;
	}
	public String getMeaning() {
		return Meaning;
	}
	public void setMeaning(String meaning) {
		Meaning = meaning;
	}
	public int getQuestionsNum() {
		return QuestionsNum;
	}
	public void setQuestionsNum(int questionsNum) {
		QuestionsNum = questionsNum;
	}
}
