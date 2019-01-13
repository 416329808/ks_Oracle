package com.oracle.daomain;

public class businessadmins {
	
	
	private String BusinessPersonID;//业务管理员ID 
	private String BusinessPersonName;//业务管理员姓名
	private String Sex;//业务管理员性别
	public String getBusinessPersonID() {
		return BusinessPersonID;
	}
	public void setBusinessPersonID(String businessPersonID) {
		BusinessPersonID = businessPersonID;
	}
	public String getBusinessPersonName() {
		return BusinessPersonName;
	}
	public void setBusinessPersonName(String businessPersonName) {
		BusinessPersonName = businessPersonName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}

	@Override
	public String toString(){
		return "Userinfo [BusinessPersonID=" + BusinessPersonID + ", BusinessPersonName=" + BusinessPersonName + ",Sex=" + Sex + "]";
	}

}
