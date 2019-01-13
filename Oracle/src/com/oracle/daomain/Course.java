package com.oracle.daomain;



public class Course {
	private String CourseID;//课程ID
	private String CourseName;//课程名
	private String ChapterNum;//章节数
	private String BelongsInstituteID;//学院ID
	private String BelongsInstituteName;//学院名
	private String TotalProblemNumber;//总习题数
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getChapterNum() {
		return ChapterNum;
	}
	public void setChapterNum(String i) {
		ChapterNum = i;
	}
	public String getBelongsInstituteID() {
		return BelongsInstituteID;
	}
	public void setBelongsInstituteID(String belongsInstituteID) {
		BelongsInstituteID = belongsInstituteID;
	}
	public String getBelongsInstituteName() {
		return BelongsInstituteName;
	}
	public void setBelongsInstituteName(String belongsInstituteName) {
		BelongsInstituteName = belongsInstituteName;
	}
	public String getTotalProblemNumber() {
		return TotalProblemNumber;
	}
	public void setTotalProblemNumber(String totalProblemNumber) {
		TotalProblemNumber = totalProblemNumber;
	}
	
	
	public Course() {
		
	}
	public Course(String courseID, String courseName, String belongsInstituteID, String belongsInstituteName,
			int chapterNum, int totalProblemNumber) {
		
		super();
		CourseID = courseID;
		CourseName = courseName;
		ChapterNum = (new Integer(chapterNum)).toString();
		BelongsInstituteID = belongsInstituteID;
		BelongsInstituteName = belongsInstituteName;
		TotalProblemNumber =  (new Integer(totalProblemNumber)).toString();
	}
	
	public Course(String courseID, String courseName, String belongsInstituteID, String belongsInstituteName) {
		
		super();
		CourseID = courseID;
		CourseName = courseName;
		BelongsInstituteID = belongsInstituteID;
		BelongsInstituteName = belongsInstituteName;
	}
	
}
