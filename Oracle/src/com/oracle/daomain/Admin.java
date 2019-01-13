package com.oracle.daomain;

public class Admin {

	private String AdminsID;
	private String AdminsName;
	private String Sex;
	public Admin() {
	
	}
	public Admin(String adminsID, String adminsName, String sex) {
		super();
		AdminsID = adminsID;
		AdminsName = adminsName;
		Sex = sex;
	}
	public String getAdminsID() {
		return AdminsID;
	}
	public void setAdminsID(String adminsID) {
		AdminsID = adminsID;
	}
	public String getAdminsName() {
		return AdminsName;
	}
	public void setAdminsName(String adminsName) {
		AdminsName = adminsName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	
	
	
	
	
}
