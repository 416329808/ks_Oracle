package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.paperNumdao;
import com.oracle.daomain.Course;
import com.oracle.util.JDBCUtil02;

public class paperNumdaoImpl implements paperNumdao{

	@Override
	public List<String> paperNum() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from EXAMINATION";
		List<Object> paramList = new ArrayList<Object>();
		JDBCUtil02 jdbcUtil = null;
		List<String> PaperList = new ArrayList<String>();
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn(); // 获取数据库链接
			System.out.println("拉取试卷表sql" +sql);
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			System.out.println("拉取试卷表,长度" + mapList.size());
			if (mapList.size() != 0) {
				for (int i = 0; i < mapList.size(); i++) {
					//System.out.println(i);
					Map<Object, Object> map = mapList.get(i);
					//System.out.println("获取试卷号" + map.get("EXAMINATIONID").toString());
					PaperList.add(map.get("EXAMINATIONID").toString());
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行试卷查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); // 一定要释放资源
			}
		}
		return PaperList;
	}
}
