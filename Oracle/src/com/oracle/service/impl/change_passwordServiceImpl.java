package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.change_passworddao;
import com.oracle.dao.impl.change_passworddaoImpl;
import com.oracle.daomain.checkperson;
import com.oracle.service.change_passwordService;

public class change_passwordServiceImpl implements change_passwordService{
	change_passworddao dao=new change_passworddaoImpl();
	@Override
	public String change(String ID,String NewPassword,String OldPassword) throws SQLException {
		// TODO Auto-generated method stub

		String npwd=dao.change(ID,NewPassword, OldPassword);
		return npwd;
	}

	@Override
	public checkperson findByID(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findByID(ID);
	}

}
