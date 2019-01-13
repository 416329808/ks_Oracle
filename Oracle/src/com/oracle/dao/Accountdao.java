package com.oracle.dao;

import com.oracle.daomain.checkperson;

public interface Accountdao {

	
	/**
	 * 通过id查找账号个体
	 * @param id
	 * @return
	 */
	public checkperson FindaccountByid(String id);
}
