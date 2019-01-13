package com.oracle.daomain;

public class Teacher {
	String TeacherID;
	String TeacherName;
	String Sex;
	String BelongsInstituteID;
	String BelongsInstituteName;
	
	public Teacher(String teacherID, String teacherName, String sex, String belongsInstituteID,
			String belongsInstituteName) {
		TeacherID = teacherID;
		TeacherName = teacherName;
		Sex = sex;
		BelongsInstituteID = belongsInstituteID;
		BelongsInstituteName = belongsInstituteName;
	}
	
	
	public String getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
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

	

}
