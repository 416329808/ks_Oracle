package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.Professiondao;
import com.oracle.daomain.InstitutePronoun;
import com.oracle.daomain.Profession;
import com.oracle.util.DButil02;

public class ProfessiondaoImpl implements Professiondao {

	@Override
	public Profession FindProfessionByname(String ProfessionName) {
	
		
		ResultSet rs=null;
		String sql="select * from ProfessionPronoun where ProfessionName=?";
		String params[]= {ProfessionName};
		
		try {
			rs=DButil02.executeQuery(sql, params);
			Profession Profession=null;
			if(rs.next()) {				
				String PROFESSIONID= rs.getString("PROFESSIONID");
				String PROFESSIONPRONOUN=rs.getString("PROFESSIONPRONOUN");
				String PROFESSIONNAME=rs.getString("PROFESSIONNAME");
				String BELONGSINSTITUTEPRONOUN=rs.getString("BELONGSINSTITUTEPRONOUN");
				String PROFESSIONINTRODUCTION=rs.getString("PROFESSIONINTRODUCTION");
				int SEQUENCES=rs.getInt("SEQUENCES");
				String ENABLES=rs.getString("ENABLES");
				String REMARKS=rs.getString("REMARKS");
				Profession=new Profession(PROFESSIONID, PROFESSIONPRONOUN, PROFESSIONNAME, BELONGSINSTITUTEPRONOUN, PROFESSIONINTRODUCTION,SEQUENCES,ENABLES,REMARKS);
				
			}
			return Profession;
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
