package com.oracle.dao.impl;

import java.sql.*;
import java.util.*;

import com.oracle.dao.QuestionTypeDao;
import com.oracle.daomain.QuestionsStylePronoun;
import com.oracle.util.DButil02;

public class QuestionTypeDaoImpl implements QuestionTypeDao	{

	@Override
	public List<QuestionsStylePronoun> QueryAllQuestionType() {
		// TODO 自动生成的方法存根 
		ResultSet rs=null;
		String sql="select * from QuestionsStylePronoun";
		String params[]=null;
		List<QuestionsStylePronoun> qsps=new ArrayList<>();
		try {
			rs=DButil02.executeQuery(sql, params);
			while(rs.next()) {
				String Pronoun=rs.getString("Pronoun");
			    String Meaning=rs.getString("Meaning");
			    int QuestionsNum=rs.getInt("QuestionsNum");
			    QuestionsStylePronoun qsp=new QuestionsStylePronoun(Pronoun,Meaning,QuestionsNum);
			    qsps.add(qsp);
			}
			return qsps;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public QuestionsStylePronoun QueryQuestionTypeByPronoun(String pronoun) {
		// TODO 自动生成的方法存根
		String sql="select * from QuestionsStylePronoun where Pronoun=?";
		String params[]= {pronoun};
		ResultSet rs=null;
		QuestionsStylePronoun qsp=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			if(rs.next()) {
			  String Meaning=rs.getString("Meaning");
			  int QuestionsNum=rs.getInt("QuestionsNum");
			  qsp=new QuestionsStylePronoun(pronoun,Meaning,QuestionsNum);
			}
			return qsp;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean Add(QuestionsStylePronoun qs) {
		// TODO 自动生成的方法存根
		String sql="insert into QuestionsStylePronoun(Pronoun,Meaning) values(?,?)";
		String params[]= {qs.getPronoun(),qs.getMeaning()};
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean DeleteByPronoun(String pronoun) {
		// TODO 自动生成的方法存根
		String sql="delete from QuestionsStylePronoun where Pronoun=?";
		String params[]= {pronoun};
		ResultSet rs=null;
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateByPronoun(String pronoun, QuestionsStylePronoun qs) {
		// TODO 自动生成的方法存根
		String sql="update QuestionsStylePronoun set Pronoun=?,Meaning=? where Pronoun=?";
		String params[]= {qs.getPronoun(),qs.getMeaning(),pronoun};
		ResultSet rs=null;
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean IsExist(String pronoun) {
		if(QueryQuestionTypeByPronoun(pronoun)!=null) return true;
		else return false;
	}

}
