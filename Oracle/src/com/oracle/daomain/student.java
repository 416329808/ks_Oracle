package com.oracle.daomain;

public class student {
	private  String StudentID;//学生ID
	private  String ClassesID;//班级ID
	private  String ClassesName;//班级名称
	private  String StudentName;//学生姓名
	private  String Sex;//性别
	private  String ProfessionID;//专业ID
	private  String InstituteID;//学院ID
	private  String ProfessionName;//专业名称
	private  String InstituteName;//学院名称
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public String getClassesID() {
		return ClassesID;
	}
	public void setClassesID(String classesID) {
		ClassesID = classesID;
	}
	public String getClassesName() {
		return ClassesName;
	}
	public void setClassesName(String classesName) {
		ClassesName = classesName;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getProfessionID() {
		return ProfessionID;
	}
	public void setProfessionID(String professionID) {
		ProfessionID = professionID;
	}
	public String getInstituteID() {
		return InstituteID;
	}
	public void setInstituteID(String instituteID) {
		InstituteID = instituteID;
	}
	public String getProfessionName() {
		return ProfessionName;
	}
	public void setProfessionName(String professionName) {
		ProfessionName = professionName;
	}
	public String getInstituteName() {
		return InstituteName;
	}
	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}
	
	public student() {
		
	}
	
	public student(String studentID, String classesID, String classesName, String studentName, String sex,
			String professionID, String instituteID, String professionName, String instituteName) {
		super();
		StudentID = studentID;
		ClassesID = classesID;
		ClassesName = classesName;
		StudentName = studentName;
		Sex = sex;
		ProfessionID = professionID;
		InstituteID = instituteID;
		ProfessionName = professionName;
		InstituteName = instituteName;
	}
	
	
	
}
