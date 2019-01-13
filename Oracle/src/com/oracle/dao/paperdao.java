package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.question;

public interface paperdao {
	public List<List<question>> getpaper(String paperNum)throws SQLException;

}
