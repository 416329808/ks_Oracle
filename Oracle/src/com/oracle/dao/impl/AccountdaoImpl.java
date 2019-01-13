package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.Accountdao;
import com.oracle.daomain.checkperson;
import com.oracle.daomain.student;
import com.oracle.util.DButil02;

public class AccountdaoImpl implements Accountdao {

	
	@Override
	public checkperson FindaccountByid(String id) {
		ResultSet rs=null;
		
		
		String sql="select * from Accounts where Accounts=?";
		String params[]= {id};
		checkperson c=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			
			if(rs.next()) {
				String ACCOUNTS=rs.getString("ACCOUNTS");
				String PASSWORDS=rs.getString("PASSWORDS");
				String STYLE=rs.getString("STYLE");
				c=new checkperson(ACCOUNTS,PASSWORDS,STYLE);
			}
			return c;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
