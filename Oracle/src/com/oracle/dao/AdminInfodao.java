package com.oracle.dao;

import com.oracle.daomain.Admin;

public interface AdminInfodao {

	
	/**
	 *通过系统管理员的id来查找管理员
	 * @param Adminid
	 * @return
	 */
public 	Admin findAdminByid(String Adminid);
	
}
