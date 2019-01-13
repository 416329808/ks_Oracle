package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface passwordService {

	public checkperson getpassword(String ID)throws SQLException;
}
