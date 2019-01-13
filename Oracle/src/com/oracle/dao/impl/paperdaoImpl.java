package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.paperdao;
import com.oracle.daomain.Course;
import com.oracle.daomain.question;
import com.oracle.util.JDBCUtil02;

public class paperdaoImpl implements paperdao{

	@Override
	public List<List<question>> getpaper(String paperNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("试卷查询dao开始");
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sqlxuan = "select * from view_juan_xuan where EXAMINATIONID=?";
		String sqlpan = "select * from view_juan_pan where EXAMINATIONID=?";
		String sqltian = "select * from view_juan_tian where EXAMINATIONID=?";
		String sqljian = "select * from view_juan_jian where EXAMINATIONID=?";
		String sqlji = "select * from view_juan_ji where EXAMINATIONID=?";
		List<Object> paramListXuan = new ArrayList<Object>();
		List<Object> paramListpan = new ArrayList<Object>();
		List<Object> paramListtian = new ArrayList<Object>();
		List<Object> paramListjian = new ArrayList<Object>();
		List<Object> paramListji = new ArrayList<Object>();
		paramListXuan.add(paperNum);
		paramListpan.add(paperNum);
		paramListtian.add(paperNum);
		paramListjian.add(paperNum);
		paramListji.add(paperNum);
		System.out.println("课程SQL语句就绪");
		JDBCUtil02 jdbcUtil = null;
		List<List<question>> List = new ArrayList<List<question>>();
		List<question> xuanList = new ArrayList<question>();
		List<question> panList = new ArrayList<question>();
		List<question> tianList = new ArrayList<question>();
		List<question> jianList = new ArrayList<question>();
		List<question> jiList = new ArrayList<question>();
		try {//分题型查询整张试卷所有题目
			System.out.println("实例化数据库连接");
			jdbcUtil = new JDBCUtil02();
			System.out.println("获取连接");
			JDBCUtil02.getConn(); // 获取数据库链接
			List<Map<Object, Object>> mapListXuan = jdbcUtil.findResult(sqlxuan.toString(), paramListXuan);
			List<Map<Object, Object>> mapListPan = jdbcUtil.findResult(sqlpan.toString(), paramListpan);
			List<Map<Object, Object>> mapListTian = jdbcUtil.findResult(sqltian.toString(), paramListtian);
			List<Map<Object, Object>> mapListJian = jdbcUtil.findResult(sqljian.toString(), paramListjian);
			List<Map<Object, Object>> mapListJi = jdbcUtil.findResult(sqlji.toString(), paramListji);
			System.out.println(mapListXuan.size());
			if (mapListXuan.size() != 0) {
				for (int i = 0; i < mapListXuan.size(); i++) {//获取选择题
					Map<Object, Object> map = mapListXuan.get(i);
					question question1 = null;// 实例化Course初始化后添加到CourseLIST
					question1 = new question();
					question1.setTopics((String) map.get("TOPICS"));
					question1.setOptionA((String) map.get("OPTIONA"));
					question1.setOptionB((String) map.get("OPTIONB"));
					question1.setOptionC((String) map.get("OPTIONC"));
					question1.setOptionD((String) map.get("OPTIOND"));
					xuanList.add(question1);
				}
			}
			if (mapListPan.size() != 0) {
				for (int i = 0; i < mapListPan.size(); i++) {//获取判断题
					Map<Object, Object> map = mapListPan.get(i);
					question question1 = null;// 实例化Course初始化后添加到CourseLIST
					question1 = new question();
					question1.setTopics((String) map.get("TOPICS"));
					panList.add(question1);
				}
			}
			if (mapListTian.size() != 0) {
				for (int i = 0; i < mapListTian.size(); i++) {//获取填空题
					Map<Object, Object> map = mapListTian.get(i);
					question question1 = null;// 实例化Course初始化后添加到CourseLIST
					question1 = new question();
					question1.setTopics((String) map.get("TOPICS"));
					tianList.add(question1);
				}
			}
			if (mapListJian.size() != 0) {
				for (int i = 0; i < mapListJian.size(); i++) {//获取简答题
					Map<Object, Object> map = mapListJian.get(i);
					question question1 = null;// 实例化Course初始化后添加到CourseLIST
					question1 = new question();
					question1.setTopics((String) map.get("TOPICS"));
					jianList.add(question1);
				}
			}
			if (mapListJi.size() != 0) {
				for (int i = 0; i < mapListJi.size(); i++) {//获取计算题
					Map<Object, Object> map = mapListJi.get(i);
					question question1 = null;// 实例化Course初始化后添加到CourseLIST
					question1 = new question();
					question1.setTopics((String) map.get("TOPICS"));
					jiList.add(question1);
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行课程查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(jdbcUtil.getConn(), jdbcUtil.getPreparedStatement(), jdbcUtil.getResultSet()); // 一定要释放资源
			}
		}
		List.add(xuanList);
		List.add(panList);
		List.add(tianList);
		List.add(jianList);
		List.add(jiList);
		return List;
	}

}
