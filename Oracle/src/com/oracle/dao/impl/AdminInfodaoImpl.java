package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.AdminInfodao;
import com.oracle.daomain.Admin;
import com.oracle.daomain.Teacher;
import com.oracle.util.DButil02;

public class AdminInfodaoImpl implements AdminInfodao {

	@Override
	public Admin findAdminByid(String Adminid) {
		
		ResultSet rs=null;
		String sql="select * from Admins where AdminsID=?";
		String params[]= {Adminid};
		Admin admin=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			if(rs.next()) {
				String ADMINSID=rs.getString("ADMINSID");
				String ADMINSNAME=rs.getString("ADMINSNAME");
				String SEX =rs.getString("SEX");
				admin=new Admin(ADMINSID,ADMINSNAME,SEX); 
			}
			return admin;
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
