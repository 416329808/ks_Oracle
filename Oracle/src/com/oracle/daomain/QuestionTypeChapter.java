package com.oracle.daomain;

public class QuestionTypeChapter {

	public String getQuestionTypePronoun() {
		return QuestionTypePronoun;
	}
	public void setQuestionTypePronoun(String questionTypePronoun) {
		QuestionTypePronoun = questionTypePronoun;
	}
	public String getMeaning() {
		return Meaning;
	}
	public void setMeaning(String meaning) {
		Meaning = meaning;
	}
	public String getChapterID() {
		return ChapterID;
	}
	public void setChapterID(String chapterID) {
		ChapterID = chapterID;
	}
	public String getChapterName() {
		return ChapterName;
	}
	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getProblemNumber() {
		return ProblemNumber.toString();
	}
	public void setProblemNumber(String problemNumber) {
		ProblemNumber = problemNumber;
	}
	private String QuestionTypePronoun;//题型代码
	private String Meaning;//题型名
	private String ChapterID;//章节ID
	private String ChapterName;//章节姓名
	private String CourseID;//课程ID
	private String ProblemNumber;//问题数
	@Override
	public String toString(){
		return "Userinfo [Meaning=" + Meaning +"QuestionTypePronoun=" + QuestionTypePronoun + ",ChapterID=" + ChapterID + ", ChapterName=" + ChapterName + ",CourseID=" + CourseID + ",ProblemNumber=" + ProblemNumber +"]";
	}
}
