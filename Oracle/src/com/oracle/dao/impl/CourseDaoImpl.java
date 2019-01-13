package com.oracle.dao.impl;

import java.sql.*;
import java.util.*;

import com.oracle.dao.CourseDao;
import com.oracle.daomain.Course;
import com.oracle.util.DButil02;

public class CourseDaoImpl implements CourseDao{

	@Override
	public List<Course> QueryAllCourse() {
		// TODO 自动生成的方法存根
		PreparedStatement pst;
		ResultSet rs=null;
		String sql="select * from Course";
		String params[]=null;
		List<Course> cs=new ArrayList<>();
		try {
			rs=DButil02.executeQuery(sql, params);
			while(rs.next()) {
				   String CourseID=rs.getString("CourseID");
				    String CourseName=rs.getString("CourseName");
				    String BelongsInstituteID=rs.getString("BelongsInstituteID");
				    String BelongsInstituteName=rs.getString("BelongsInstituteName");
				    int chapterNum=Integer.parseInt(rs.getString("ChapterNum"));
				    int totalProblemNumber=Integer.parseInt(rs.getString("TotalProblemNumber"));
				    Course cou=new Course(CourseID,CourseName,BelongsInstituteID,BelongsInstituteName,chapterNum,totalProblemNumber);
				    cs.add(cou);
			}
			return cs;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public Course QueryById(String id) {
		// TODO 自动生成的方法存根
		String sql="select * from Course where CourseID=?";
		String []params= {id};
		ResultSet rs=null;
		Course cou=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			if(rs.next()) {
				 String courseID=rs.getString("CourseID");
				    String courseName=rs.getString("CourseName");
				    String belongsInstituteID=rs.getString("BelongsInstituteID");
				    String belongsInstituteName=rs.getString("BelongsInstituteName");
				    int chapterNum=Integer.parseInt(rs.getString("ChapterNum"));
				    int totalProblemNumber=Integer.parseInt(rs.getString("TotalProblemNumber"));
				    cou=new Course(courseID,courseName,belongsInstituteID,belongsInstituteName,chapterNum,totalProblemNumber);
			}
			return cou;
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
	public boolean Add(Course c) {
		// TODO 自动生成的方法存根
		String sql="insert into Course(courseID,courseName,belongsInstituteName)"
				+ "values(?,?,?)";
		String params[]= {c.getCourseID(),c.getCourseName(),c.getBelongsInstituteName()};
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
	public boolean DeleteById(String id) {
		// TODO 自动生成的方法存根
		String sql="delete from Course where CourseID=?";
		String params[]= {id};
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
	public boolean UpdateById(String id, Course c) {
		// TODO 自动生成的方法存根
		String sql="update Course set CourseID=?,CourseName=?,BelongsInstituteID=?,BelongsInstituteName=? where CourseID=?";
		String params[]= {c.getCourseID(),c.getCourseName(),c.getBelongsInstituteID(),c.getBelongsInstituteName(),id};
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
	public boolean IsExist(String id) {
		// TODO 自动生成的方法存根
		Course cou=QueryById(id);
		if(cou!=null) return true;
		else return false;
	}

}
