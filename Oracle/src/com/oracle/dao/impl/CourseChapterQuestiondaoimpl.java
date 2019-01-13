package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.dao.CourseChapterQuestiondao;
import com.oracle.daomain.Chapter;
import com.oracle.daomain.Course;
import com.oracle.daomain.PageBean;
import com.oracle.daomain.QuestionTypeChapter;
import com.oracle.daomain.Questions;
import com.oracle.util.JDBCUtil02;

public class CourseChapterQuestiondaoimpl implements CourseChapterQuestiondao {

	@Override
	public List<Chapter> FindChapterbyCourseID(Course course) throws SQLException {
		List<Chapter> chapterlist = new ArrayList<Chapter>();
		String sql = "select * from  Chapter where CourseID=?";
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(course.getCourseID().replaceAll("'", ""));
		System.out.println(course.getCourseID().replaceAll("'", ""));
		Chapter chapter = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			System.out.println(size);
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					chapter = new Chapter();
					
					chapter.setChapterID((String) map.get("CHAPTERID"));
					chapter.setChapterName((String) map.get("CHAPTERNAME"));

					chapterlist.add(chapter);
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
		System.out.println("zhangjiejihe"+chapterlist);
		return chapterlist;
	}

	@Override
	public List<QuestionTypeChapter> FindChapterbyChapterID(Chapter chapter) throws SQLException {
		List<QuestionTypeChapter> questionchapterList = new ArrayList<QuestionTypeChapter>();
		String sql = "select * from  QuestionType_Chapter where CourseID=? and ChapterID=?";
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(chapter.getCourseID().replaceAll("'", ""));
		paramList.add(chapter.getChapterID().replaceAll("'", ""));
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
					questionTypeChapter.setProblemNumber((map.get("PROBLEMNUMBER")).toString());
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
		System.out.println(questionchapterList);
		return questionchapterList;
	}

	@Override
	public PageBean<Questions> FindQuestionbyAll(QuestionTypeChapter questionTypeChapter) throws SQLException {

		return null;
	}

}
