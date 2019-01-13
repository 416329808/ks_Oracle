package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.dao.businessadminsinfo;
import com.oracle.daomain.businessadmins;
import com.oracle.util.JDBCUtil02;

public class businessadminsinfoimpl implements businessadminsinfo {

	public businessadminsinfoimpl() {
	}

	@Override
	/*
	 *通过业务管理员ID查找业务管理员的实现
	 * @throws SQLException
	 * param BusinessPersonID
	 */
	public businessadmins findbusBusinessadmins(String BusinessPersonID) throws SQLException {
		String sql="select * from BusinessAdmins where BusinessPersonID=? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(BusinessPersonID);
		JDBCUtil02 jdbcUtil=null;
		businessadmins businessadmin=null;
		try {	
			jdbcUtil= new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			if (mapList.size()==1) {
				Map<Object, Object> map = mapList.get(0);

				businessadmin=new businessadmins();
				businessadmin.setBusinessPersonID((String) map.get("BUSINESSPERSONID"));
				businessadmin.setBusinessPersonName((String) map.get("BUSINESSPERSONNAME"));
				businessadmin.setSex((String) map.get("SEX"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return businessadmin;
	}

}
