package com.oracle.dao;

import java.sql.SQLException;

import com.oracle.daomain.businessadmins;

public interface businessadminsinfo{
	/**
	 * 通过业务管理员ID查找管理员信息
	 * @param BusinessPersonID
	 * @return
	 */
  public businessadmins findbusBusinessadmins (String BusinessPersonID)throws SQLException;
}
