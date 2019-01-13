package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.studentInfo;
import com.oracle.daomain.student;
import com.oracle.util.JDBCUtil02;

public class studentInfoImpl implements studentInfo {
/**
 * 通过学生ID查找学生的实现
 * @throws SQLException 
 */
	@Override
	public student findstudent(String StudentID) throws SQLException {
		
		//QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from Student where StudentID=? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(StudentID);
		JDBCUtil02 jdbcUtil=null;
		student student=null;
		try {
			jdbcUtil= new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			if (mapList.size()==1) {
				Map<Object, Object> map = mapList.get(0);
				//System.out.println("22222"+map.get("STUDENTNAME"));
                student=new student();
                student.setStudentID((String) map.get("STUDENTID"));
                student.setStudentName((String) map.get("STUDENTNAME"));
			    student.setSex((String) map.get("SEX"));
			    student.setInstituteName((String) map.get("INSTITUTENAME"));
			    student.setProfessionName((String) map.get("PROFESSIONNAME"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(jdbcUtil.getConn(),jdbcUtil.getPreparedStatement(),jdbcUtil.getResultSet()); // 一定要释放资源
			}
		
		
		//System.out.println("11111");
		//System.out.println(student.getStudentName());
		
		return student;
	}

	}
}