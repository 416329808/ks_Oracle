package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.checkperson;
import com.oracle.daomain.question;

public interface paperService {

	public List<List<question>> Login(String paperNum)throws SQLException;
}
