<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="com.oracle.daomain.question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row"></div>
		<div class="col-md-11"></div>
		<div class="col-md-1">
			<button type="button" class="btn btn-success" id="sure">提交</button>
		</div>

		<table class="table table-condensed">
			<thead>
				<tr>
					<th><h4>选择题</h4></th>
				</tr>
			</thead>
			<tbody>
				<%
		List<List<question>> list = (List<List<question>>) request.getAttribute("list");
			List<question> xuan=list.get(0);
			List<question> pan=list.get(1);
			List<question> tian=list.get(2);
			List<question> jian=list.get(3);
			List<question> ji=list.get(4);
				int i=0;
				for (question question1 : xuan) { 
				i++;
				%>
				<tr>
					<td>
						<div class="form-group col-md-11">
							<!-- 序号 -->
							<label class="col-sm-1 control-label"><%=i %></label>
							<!--  题目 -->
							<div class="col-sm-11"><%= question1.getTopics()%>
							<br>
							<%=question1.getOptionA() %>
														<br>
							<%=question1.getOptionB() %>
														<br>
							<%=question1.getOptionC() %>
														<br>
							<%=question1.getOptionD() %>
							</div>
						</div> <!-- 填入的答案 -->
						<div class="col-md-1">
							<input type="text" class="form-control ">
						</div>
					</td>
				</tr>
				<% }%>
				<tr>
					<td><h4>填空题</h4></td>
				</tr>
				<%				
				i=0;
				for (question question1 : tian) { 
				i++; %>
				<tr>
					<td>
						<div class="form-group col-md-10">
							<!-- 序号 -->
							<label class="col-sm-1 control-label"><%=i %></label>
							<!--  题目 -->
							<div class="col-sm-11"><%=question1.getTopics() %></div>
						</div> <!-- 填入的答案 -->
						<div class="col-md-2">
							<input type="text" class="form-control ">
						</div>
					</td>
				</tr>
				<% }%>
				<tr>
					<td><h4>判断题</h4></td>
				</tr>
				<%				
				i=0;
				for (question question1 : pan) { 
				i++; %>
				<tr>
					<td>
						<div class="form-group col-md-10">
							<!-- 序号 -->
							<label class="col-sm-1 control-label"><%=i %></label>
							<!--  题目 -->
							<div class="col-sm-11"><%=question1.getTopics() %></div>
						</div> <!-- 填入的答案 -->
						<div class="col-md-2">
							<input type="text" class="form-control ">
						</div>
					</td>
				</tr>
				<% }%>
				<tr>
					<td><h4>计算题</h4></td>
				</tr>
				<%				
				i=0;
				for (question question1 : ji) { 
				i++; %>
				<tr>
					<td>
						<div class="form-group col-md-10">
							<!-- 序号 -->
							<label class="col-sm-1 control-label"><%=i %></label>
							<!--  题目 -->
							<div class="col-sm-11"><%=question1.getTopics() %></div>
						</div> <!-- 填入的答案 -->
						<div class="col-md-2">
							<input type="text" class="form-control ">
						</div>
					</td>
				</tr>
				<% }%>

				<tr>
					<td><h4>简答题</h4></td>
				</tr>
				<%				
				i=0;
				for (question question1 : jian) { 
				i++; %>
				<tr>
					<td>
						<div class="form-group col-md-10">
							<!-- 序号 -->
							<label class="col-sm-1 control-label"><%=i %></label>
							<!--  题目 -->
							<div class="col-sm-11"><%=question1.getTopics() %></div>
						</div> <!-- 填入的答案 -->
						<div class="col-md-2">
							<input type="text" class="form-control ">
						</div>
					</td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</div>
</body>
</html>