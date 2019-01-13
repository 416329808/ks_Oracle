package com.oracle.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DButil02 {
	
	// 定义sql语句的执行对象
	private static PreparedStatement pst=null;

	public static Connection conn=null;
	// 定义查询返回的结果集合
	private static ResultSet rs=null;
	
	//C3p0建立数据库连接
	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource("");
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	
	//获取PreparedStatement对象
	public static PreparedStatement createprepareStatement(String sql,Object []params) throws SQLException, ClassNotFoundException {
		pst=getConn().prepareStatement(sql);
		System.out.println("prepare:"+params);
		if(params!=null && params.length!=0) {
			for(int i=0;i<params.length;i++) {
			    pst.setObject(i+1, params[i]);
			}
		}
		return pst;
	}

	
	public static ResultSet executeQuery(String sql,Object []params) throws ClassNotFoundException, SQLException {
		pst=createprepareStatement(sql,params);
		rs=pst.executeQuery();
		return rs;
	}
	
	public static int executeUpdate(String sql,Object []params) throws SQLException, ClassNotFoundException {
		pst=createprepareStatement(sql,params);
		int count=pst.executeUpdate();
		CloseAll(null,pst,null);
		return count;
	}
	
	public static void CloseAll(ResultSet rs,Statement pst,Connection conn) {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
	}
}
