package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.InstitutePronounDao;
import com.oracle.daomain.InstitutePronoun;
import com.oracle.daomain.Teacher;
import com.oracle.daomain.student;
import com.oracle.util.DButil02;
import com.oracle.util.JDBCUtil02;

public class InstitutePronounDaoImpl implements InstitutePronounDao {
/**
 * 按照学院名字查询出指定学院
 */
	@Override
	public InstitutePronoun FindinstitutepronounByname(String InstituteName) {
		
		ResultSet rs=null;
		String sql="select * from InstitutePronoun where InstituteName=?";
		String params[]= {InstituteName};
		
		try {
			rs=DButil02.executeQuery(sql, params);
			InstitutePronoun institute=null;
			if(rs.next()) {
				
				String INSTITUTEPRONOUN= rs.getString("INSTITUTEPRONOUN");
				String INSTITUTENAME=rs.getString("INSTITUTENAME");
				int SEQUENCES=rs.getInt("SEQUENCES");
				String ENABLES=rs.getString("ENABLES");
				String REMARKS=rs.getString("REMARKS");
				 institute=new InstitutePronoun(INSTITUTEPRONOUN, INSTITUTENAME, SEQUENCES, ENABLES, REMARKS);
				
			}
			return institute;
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
