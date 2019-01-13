package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.change_passworddao;
import com.oracle.daomain.checkperson;
import com.oracle.daomain.student;
import com.oracle.util.JDBCUtil02;
import com.oracle.util.md5;

public class change_passworddaoImpl implements change_passworddao{

	@Override
	/**
	*更改密码
	*/
	public String change(String ID,String NewPassword,String OldPassword) throws SQLException {
		// TODO Auto-generated method stub
		//QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		String sql="UPDATE Accounts SET Passwords = ? WHERE Accounts = ?";
		System.out.println("修改密码SQL语句就绪"+NewPassword+ID);
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println("创建学生信息list");
		NewPassword=md5.md5andbase64(NewPassword);
		//System.out.println("加密后"+pwd);
		//System.out.println("输入信息"+name+pwd);
		paramList.add(NewPassword);
		paramList.add(ID);
		JDBCUtil02 jdbcUtil = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn(); // 获取数据库链接
			int i = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			System.out.println("修改密码"+NewPassword);
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行修改密码操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return NewPassword;
		
	}

	@Override
	public checkperson findByID(String ID) throws SQLException {
		String sql="select * from ACCOUNTS where ACCOUNTS=? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(ID);
		JDBCUtil02 jdbcUtil=null;
		checkperson checkperson=new checkperson();;
		try {
			jdbcUtil= new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			if (mapList.size()==1) {
				Map<Object, Object> map = mapList.get(0);
				checkperson.setPasswords((String)map.get("PASSWORDS"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return checkperson;
	}
	
}
