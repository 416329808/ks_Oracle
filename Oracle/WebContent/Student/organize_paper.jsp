<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
	<form id="form" name="form" action="/Oracle/paperServlet"
		method="post">
		<br>
		<div>
			<label for="no" class="col-md-1 control-label">试卷编号:</label> <select
				id="Chapter_paper_select" name="Chapter_paper_select">
				
				<%
				List<String> paperlist = (List<String>) request.getAttribute("PaperList");
				for (String paperNum : paperlist) {
			%>
				<option value="<%=paperNum%>"><%=paperNum%></option>
				<%
				}
			%>
			</select> <button type="submit" class="btn btn-primary">查询</button>
		</div>
		<br>
		<br>
	</form>
	<form id="form" name="form" action="/Oracle/oranize_paperServlet"
		method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-2">选择题</div>
				<div class="col-md-2">填空题</div>
				<div class="col-md-2">判断题</div>
				<div class="col-md-2">计算题</div>
				<div class="col-md-2">简答题</div>
			</div>
			<br>
			<div class="row">
				<div>
					<select class=" col-md-2"
						style="text-align: center; text-align-last: center;" id="xuan"
						name="xuan">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div>
					<select class="col-md-2"
						style="text-align: center; text-align-last: center;" id="tian"
						name="tian">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div>
					<select class="col-md-2"
						style="text-align: center; text-align-last: center;" id="pan"
						name="pan">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div>
					<select class="col-md-2"
						style="text-align: center; text-align-last: center;" id="ji"
						name="ji">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div>
					<select class="col-md-2"
						style="text-align: center; text-align-last: center;" id="jian"
						name="jian">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-2">
					<button type="submit" class="btn btn-primary" id="sure">组卷</button>
				</div>
				<div class="col-md-5"></div>
			</div>
		</div>
	</form>
</body>
</html>