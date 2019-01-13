package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.dao.logindao;
import com.oracle.daomain.checkperson;
import com.oracle.util.JDBCUtil02;
import com.oracle.util.md5;

public class logindaoImpl implements logindao {

	@Override
	public checkperson Login(String name, String pwd) throws SQLException {
		
		
		//QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from Accounts where Accounts=? and Passwords=? ";
		List<Object> paramList = new ArrayList<Object>();
		pwd=md5.md5andbase64(pwd);
		//System.out.println(pwd);
		// 填充参数
		paramList.add(name);
		paramList.add(pwd);
		JDBCUtil02 jdbcUtil = null;
		checkperson checkperson1 = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn(); // 获取数据库链接
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			System.out.println(mapList);
			if (mapList.size() == 1) {
				Map<Object, Object> map = mapList.get(0);
				checkperson1=new checkperson();
				checkperson1.setAccounts((String) map.get("ACCOUNTS"));
				checkperson1.setPasswords((String) map.get("PASSWORDS"));
				checkperson1.setStyle((String) map.get("STYLE"));
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return checkperson1;

	}

}
