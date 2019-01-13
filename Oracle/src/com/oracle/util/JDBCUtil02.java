package com.oracle.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil02 {
	public static  PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public static  ResultSet getResultSet() {
		return resultSet;
	}

	// 定义sql语句的执行对象
	private static PreparedStatement preparedStatement;

	// 定义查询返回的结果集合
	private static ResultSet resultSet;
	
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
	public static  Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	
	/*
	 *	 * 执行更新操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return
	 * @throws SQLException
	 */
	public int updateByPreparedStatement(String sql, List<?> params) throws SQLException {
		int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
		preparedStatement = getConn().prepareStatement(sql);
		int index = 1;
		// 填充sql语句中的占位符
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
				//System.out.println(params.get(i));
			}
		}
		
		result = preparedStatement.executeUpdate();
		return result;
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return
	 * @throws SQLException
	 */
	public List<Map<Object, Object>> findResult(String sql, List<?> params) throws SQLException {
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		int index = 1;
		preparedStatement = getConn().prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<Object, Object> map = new HashMap<Object, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , Statement st){
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
