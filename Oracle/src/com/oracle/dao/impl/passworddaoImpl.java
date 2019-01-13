package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.passworddao;
import com.oracle.daomain.checkperson;
import com.oracle.util.JDBCUtil02;

public class passworddaoImpl implements passworddao{

	@Override
	public checkperson getperson(String ID) throws SQLException {//获取该用户密码
		// TODO Auto-generated method stub
		QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from Accounts where Accounts=?";
		//System.out.println("SQL语句就绪");
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println("创建学生信息list");
		//pwd=md5.md5andbase64(pwd);
		//System.out.println("加密后"+pwd);
		//System.out.println("输入信息"+name+pwd);
		paramList.add(ID);
		JDBCUtil02 jdbcUtil = null;
		checkperson checkperson1 = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn(); // 获取数据库链接
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			//System.out.println("拉取学生信息"+mapList);
			if (mapList.size() == 1) {
				Map<Object, Object> map = mapList.get(0);
				checkperson1=new checkperson();
				checkperson1.setAccounts((String) map.get("ACCOUNTS"));
				checkperson1.setPasswords((String) map.get("PASSWORDS"));
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(jdbcUtil.getConn(),jdbcUtil.getPreparedStatement(),jdbcUtil.getResultSet()); // 一定要释放资源
			}
		}
		return checkperson1;
	}

}
