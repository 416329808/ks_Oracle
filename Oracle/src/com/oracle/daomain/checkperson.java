package com.oracle.daomain;

public class checkperson {
	
	public checkperson() {
		
	}
	
	public checkperson(String accounts, String passwords, String style) {
		super();
		Accounts = accounts;
		Passwords = passwords;
		Style = style;
	}
	
	public String getAccounts() {
		return Accounts;
	}
	public void setAccounts(String accounts) {
		Accounts = accounts;
	}
	public String getPasswords() {
		return Passwords;
	}
	public void setPasswords(String passwords) {
		Passwords = passwords;
	}
	public String getStyle() {
		return Style;
	}
	public void setStyle(String style) {
		Style = style;
	}
	private String Accounts;//账号
	private String Passwords;//密码
	private String Style;//类型
	@Override
	public String toString() {
		return "Userinfo [Accounts=" + Accounts + ", pwd=" + Passwords + ",Style=" + Style + "]";
	}
	
}
