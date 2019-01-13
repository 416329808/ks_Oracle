<%@page import="com.oracle.daomain.QuestionTypeChapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
	<%
		QuestionTypeChapter questionTypeChapter = (QuestionTypeChapter) request.getAttribute("questionTypeChapter");
		String CourseID =new String(questionTypeChapter.getCourseID());//课程编号
		String meaning = questionTypeChapter.getMeaning();

	%>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancel").click(function() {
			location.href = "/Oracle/ChapterinfoServlet?pageNum=1";
		});
	});
</script>

<body>
	<div class="container">

		<br>
		<div class="row">
			<form id="form" name="form" class="form-horizontal"
				action="/Oracle/ChapterUpdateServlet?style='add'" method="post">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>章节号</th>
							<th>章节名</th>
							<th>章节题型问题数</th>
							<th>所属课程号</th>
							<th>包含题型</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								style="width: 100%" name="ChapterID" value="${questionTypeChapter.chapterID}" readonly="readonly"></td>
							<td><input type="text" class="form-control"
								style="width: 100%" name="ChapterName" value="${questionTypeChapter.chapterName}"></td>
							<td><input type="text" class="form-control"
								style="width: 100%" name="ProblemNumber" value="${questionTypeChapter.problemNumber}"></td>
							<td><select name="courseselect"  >
									<option value="1104201509"<%if("1104201506".equals(CourseID)){%> selected<%} %>>计算机组成原理</option>
									<option value="1104201506"<%if("1104201506".equals(CourseID)){%> selected<%} %>>计算机组成原理</option>
									<option value="1104201507"<%if("1104201507".equals(CourseID)){%> selected<%} %>>计算机网络</option>
									<option value="1104201508"<%if("1104201508".equals(CourseID)){%> selected<%} %>>数据结构</option>
								</select>
								</td>
				<td><input type="checkbox" value="1" name="boxes" id="boxes1"<%if ("选择题".equals(meaning)) {%> checked<%}%>>选择题<br> 
					<input type="checkbox" value="3" name="boxes" id="boxes3"<%if ("填空题".equals(meaning)) {%> checked<%}%>>填空题<br> 
					<input type="checkbox" value="5" name="boxes" id="boxes5"<%if ("计算题".equals(meaning)) {%> checked<%}%>>计算题<br>
					<input type="checkbox" value="4" name="boxes" id="boxes4"<%if ("简答题".equals(meaning)) {%> checked<%}%>>简答题<br>
					<input type="checkbox" value="2" name="boxes" id="boxes2"<%if ("判断题".equals(meaning)) {%> checked<%}%>>判断题<br>
							</td>
						</tr>

					</tbody>
				</table>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-primary" id="sure">确认</button>
					</div>
					<div class="col-md-2">
						<button type="button" class="btn btn-primary" id="cancel"
							onclick="location.href = '/Oracle/ChapterinfoServlet?pageNum=1'">取消</button>
					</div>
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>

	</div>

</body>
</html>