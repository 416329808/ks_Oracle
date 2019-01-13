<%@page import="com.oracle.daomain.question"%>
<%@page import="com.oracle.daomain.Course"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="../js/bootstrap.js">
	
</script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
<style>
table {
	table-layout: fixed;
}

td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
</head>
<body>
<form id="form" name="form" class="form-horizontal"
		action="/Oracle/SerchQuestionServlet" method="post">
	<br>
	<div class="container_fluid">
		<div class="row">
			<div class="col-md-8">
				<label>课程:</label> 
				<select name="Course_type_select"
					id="Course_type_select">
					<%
					  		String CourseID=(String)request.getAttribute("CourseID");
							String Chapter=(String)request.getAttribute("Chapter");
							String type=(String)request.getAttribute("Type");
							List<Course> Courselist = (List<Course>) request.getAttribute("Course");
							for (Course Course1 : Courselist) {
					%>
					<option value="<%=Course1.getCourseID()%>"<%if(Course1.getCourseID().equals(CourseID)){%> selected<%} %>><%=Course1.getCourseName()%></option>
					<%
						}
					%>
				</select> <label>章节:</label> <select name="Chapter_type_select"
					id="Chapter_type_select">
					<option value="1"<%if("1".equals(Chapter)){%> selected<%} %>>第1章</option>
					<option value="2"<%if("2".equals(Chapter)){%> selected<%} %>>第2章</option>
					<option value="3"<%if("3".equals(Chapter)){%> selected<%} %>>第3章</option>
					<option value="4"<%if("4".equals(Chapter)){%> selected<%} %>>第4章</option>
					<option value="5"<%if("5".equals(Chapter)){%> selected<%} %>>第5章</option>
				</select> 	
				<label>题型:</label> <select name="Type_type_select"
					id="Type_type_select">
					<option value="1"<%if("1".equals(type)){%> selected<%} %>>选择题</option>
					<option value="2"<%if("2".equals(type)){%> selected<%} %>>判断题</option>
					<option value="3"<%if("3".equals(type)){%> selected<%} %>>填空题</option>
					<option value="4"<%if("4".equals(type)){%> selected<%} %>>简答题</option>
					<option value="5"<%if("5".equals(type)){%> selected<%} %>>计算题</option>
				</select>
			</div>
			<div class="col-md-2">
				<input type="text" class="form-control" id="teaName" name="teaName"
					placeholder="请输入查询条件" style="width: 100%">
			</div>
			<div class="col-md-2">
			<button type="submit" class="btn btn-primary btn-sm" id="searchBtn">查询</button>
		</div>
		</div>

		<!--  显示题目 -->
		<table class="table table-condensed">
			<thead>
				<tr>
					<th width="10%">编号</th>
					<th width="90%">题目内容</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<question> qlist = (List<question>) request.getAttribute("Qlist");
					int i=0;
					for (question question1 : qlist) {
					i++;
				%>
				<tr>
					<td width="10%"><%=i %></td>
					<td width="90%"><a href="./Student/details.jsp?QuestionTopics=<%=question1.getTopics() %>&QuestionAnswer=<%=question1.getAnswer() %>&QuestionAnaly<%=question1.getAnalysiss() %>"
						style="overflow: hidden; text-overflow: ellipsis;"><%=question1.getTopics() %>
					</a></td>
				</tr>
				<%
						}
				%>
			</tbody>
		</table>
	</div>
	</form>
</body>
</html>