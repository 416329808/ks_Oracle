package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.dao.QuestionTypeChapterinfo;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.util.JDBCUtil02;

public class QuestionTypeChapterinfoimpl implements QuestionTypeChapterinfo {

	@Override
	public List<QuestionTypeChapter> findAllQuestionTypeChapter(int pageNum,int pageSize) throws SQLException {
		List<QuestionTypeChapter> questionchapterList = new ArrayList<QuestionTypeChapter>();
		String sql = "select * from  QuestionType_Chapter where rownum<?  minus  select * from  QuestionType_Chapter where rownum<?";
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(pageNum*pageSize+1);
		//System.out.println(pageNum*pageSize+1);
		paramList.add((pageNum-1)*pageSize+1);
		QuestionTypeChapter questionTypeChapter = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questionTypeChapter = new QuestionTypeChapter();

					questionTypeChapter.setQuestionTypePronoun((String) map.get("QUESTIONTYPEPRONOUN"));
					questionTypeChapter.setMeaning((String) map.get("MEANING"));
					questionTypeChapter.setChapterID((String) map.get("CHAPTERID"));
					questionTypeChapter.setChapterName((String) map.get("CHAPTERNAME"));
					questionTypeChapter.setCourseID((String) map.get("COURSEID"));
					questionTypeChapter.setProblemNumber(map.get("PROBLEMNUMBER").toString());

					questionchapterList.add(questionTypeChapter);
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questionchapterList;
	}

	@Override
	public int addquestionchapter(QuestionTypeChapter questionTypeChapter) throws SQLException {

		JDBCUtil02 jdbcUtil = null;
		jdbcUtil = new JDBCUtil02();
		// 获取数据库链接
		JDBCUtil02.getConn();
		
		int ra=addchapter(jdbcUtil,questionTypeChapter);
		if (ra==0) {
			return -1;
		}
		String sql = "insert into QuestionType_Chapter(QuestionTypePronoun,Meaning,ChapterID,ChapterName,CourseID) values(?,?,?,?,?)";
		List<Object> paramList = new ArrayList<Object>();
		List<Object> paramList1 = new ArrayList<Object>();

		//获得每个题型的代码
		String sqlString = "select Meaning from QuestionsStylePronoun where Pronoun = ?";
		paramList1.add(questionTypeChapter.getQuestionTypePronoun());
		int r = 0;
		int row = 0;
		// System.out.println(paramList1);
		try {


			List<Map<Object, Object>> mapList1 = jdbcUtil.findResult(sqlString.toString(), paramList1);
			if (mapList1.size() >= 1) {
				Map<Object, Object> map1 = mapList1.get(0);
				//System.out.println(map1);
				questionTypeChapter.setMeaning((String) map1.get("MEANING"));
				System.out.println((String)map1.get("MEANING"));
			}
			//System.out.println(questionTypeChapter);
			paramList.add(questionTypeChapter.getQuestionTypePronoun());
			paramList.add(questionTypeChapter.getMeaning());
			paramList.add(questionTypeChapter.getChapterID());
			paramList.add(questionTypeChapter.getChapterName());
			paramList.add(questionTypeChapter.getCourseID());
			//System.out.println("集合" + paramList);
			r = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			//System.out.println("大小" + paramList.size());
			//System.out.println(r);
			row += r;
			paramList = new ArrayList<Object>();

		} catch (Exception e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return row;
	}

	public int addchapter(JDBCUtil02 jdbcUtil, QuestionTypeChapter questionTypeChapter) throws SQLException {
		// 向章节表中插入数据
		List<Object> paramList2 = new ArrayList<Object>();
		paramList2.add(questionTypeChapter.getChapterID());
		paramList2.add(questionTypeChapter.getChapterName());
		paramList2.add(questionTypeChapter.getCourseID());
		int r = 0;
		String stringsql = "insert into Chapter(ChapterID,ChapterName,CourseID) values(?,?,?)";
		try {
			r = jdbcUtil.updateByPreparedStatement(stringsql.toString(), paramList2);
		} catch (Exception e) {
		
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return r;
	}

	@Override
	public int deletechapterByID(QuestionTypeChapter questionTypeChapter)throws SQLException {
		JDBCUtil02 jdbcUtil = null;

		int r=0;
		try {
		String sqlString = "select Pronoun from QuestionsStylePronoun where Meaning = ?";
		List<Object> paramList1 = new ArrayList<Object>();
		paramList1.add(questionTypeChapter.getMeaning().replace("'", ""));
		//System.out.println(questionTypeChapter.getMeaning());
			jdbcUtil = new JDBCUtil02();
			// 获取数据库链接
			JDBCUtil02.getConn();
			System.out.println(sqlString+paramList1.get(0));
			List<Map<Object, Object>> mapList1 = jdbcUtil.findResult(sqlString, paramList1);
			if (mapList1.size() >= 1) {
				Map<Object, Object> map1 = mapList1.get(0);
				System.out.println(map1);
				questionTypeChapter.setQuestionTypePronoun((String) map1.get("PRONOUN"));
				System.out.println("查询结果"+(String)map1.get("PRONOUN"));
			}
			System.out.println("结果集"+mapList1);
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(questionTypeChapter.getQuestionTypePronoun());
			paramList.add(questionTypeChapter.getChapterID().replace("'", ""));
			paramList.add(questionTypeChapter.getCourseID().replace("'", ""));
			String sql = "delete from QuestionType_Chapter where QuestionTypePronoun=? and ChapterID=? and CourseID=?";
			System.out.println(paramList.get(0));
			System.out.println(paramList.get(1));
			System.out.println(paramList.get(2));
			System.out.println(sql);
			r = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			
		} catch (Exception e) {
			System.out.println("删除失败");
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return r;
	}

	@Override
	public int updatechapterByID(QuestionTypeChapter questionTypeChapter) throws SQLException {
		JDBCUtil02 jdbcUtil = null;
		jdbcUtil = new JDBCUtil02();
		// 获取数据库链接
		JDBCUtil02.getConn();
		
		String sql = "update QuestionType_Chapter set ProblemNumber=? where Meaning=? and ChapterID=? and CourseID=?";
		List<Object> paramList = new ArrayList<Object>();
		List<Object> paramList1 = new ArrayList<Object>();

		//获得每个题型的代码
		String sqlString = "select Meaning from QuestionsStylePronoun where Pronoun = ?";
		paramList1.add(questionTypeChapter.getQuestionTypePronoun());
		int r = 0;
		int row = 0;
		// System.out.println(paramList1);
		try {

			List<Map<Object, Object>> mapList1 = jdbcUtil.findResult(sqlString.toString(), paramList1);
			if (mapList1.size() >= 1) {
				Map<Object, Object> map1 = mapList1.get(0);
				System.out.println(map1);
				questionTypeChapter.setMeaning((String) map1.get("MEANING"));
				System.out.println((String)map1.get("MEANING"));
			}
			//System.out.println(questionTypeChapter);
			paramList.add(questionTypeChapter.getProblemNumber());
			paramList.add(questionTypeChapter.getMeaning());
			paramList.add(questionTypeChapter.getChapterID());
			paramList.add(questionTypeChapter.getCourseID());
			//System.out.println("集合" + paramList);
			r = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			//System.out.println("大小" + paramList.size());
			//System.out.println(r);
			row += r;
			paramList = new ArrayList<Object>();
			System.out.println("影响行数:"+row);

		} catch (Exception e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return row;
	}

	@Override
	public QuestionTypeChapter findByID(QuestionTypeChapter questionTypeChapter) throws SQLException {
		return null;
	}

	@Override
	public List<QuestionTypeChapter> findAllQuestionTypeChapter() throws SQLException {
		List<QuestionTypeChapter> questionchapterList = new ArrayList<QuestionTypeChapter>();
		String sql = "select * from  QuestionType_Chapter";
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		List<Object> paramList = new ArrayList<Object>();
		QuestionTypeChapter questionTypeChapter = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questionTypeChapter = new QuestionTypeChapter();

					questionTypeChapter.setQuestionTypePronoun((String) map.get("QUESTIONTYPEPRONOUN"));
					questionTypeChapter.setMeaning((String) map.get("MEANING"));
					questionTypeChapter.setChapterID((String) map.get("CHAPTERID"));
					questionTypeChapter.setChapterName((String) map.get("CHAPTERNAME"));
					questionTypeChapter.setCourseID((String) map.get("COURSEID"));
					questionTypeChapter.setProblemNumber(map.get("PROBLEMNUMBER").toString());

					questionchapterList.add(questionTypeChapter);
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questionchapterList;
	}

}
