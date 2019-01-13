package com.oracle.daomain;

public class Questions {

	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public String getQuestionsID() {
		return questionsID;
	}
	public void setQuestionsID(String questionsID) {
		this.questionsID = questionsID;
	}
	public String getChapterID() {
		return chapterID;
	}
	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDifficult() {
		return difficult;
	}
	public void setDifficult(String difficult) {
		this.difficult = difficult;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getExtractNum() {
		return extractNum;
	}
	public void setExtractNum(String extractNum) {
		this.extractNum = extractNum;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnalysiss() {
		return analysiss;
	}
	public void setAnalysiss(String analysiss) {
		this.analysiss = analysiss;
	}
	public String getReporterID() {
		return reporterID;
	}
	public void setReporterID(String reporterID) {
		this.reporterID = reporterID;
	}
	private String questionsID;//题号
	private String chapterID;//所属章节
	private String courseID;//课程ID
	private String style;//题型
	private String topics;//题目
	private String score;//分数
	private String difficult;//难度
	private String creationDate;//创建时间
	private String extractNum;//抽取次数
	private String answer;//答案
	private String analysiss;//解析
	private String reporterID;//录入人员ID
	private String courseName;//课程名
	private String chapterName;//章节名
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	@Override
	public String toString(){
		return "Userinfo [questionsID=" + questionsID +"analysiss=" + analysiss+"chapterID=" + chapterID + ",courseID=" + courseID + ", courseName=" + courseName + ",courseID=" + courseID + ",chapterName=" + chapterName +"]";
	}

	

}
