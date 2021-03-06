<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.oracle.daomain.Questions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="/Oracle/QuestionsinfoServlet";
		});});
</script>
<body>
	<%
		Questions questions2 = (Questions) request.getAttribute("questions2");
		if (questions2 != null) {
			String topics = questions2.getTopics();//章节号
			String answer = questions2.getAnswer();//章节名
			String analysiss =questions2.getAnalysiss();//课程编号

	%>
	<div class="container">
		<div class="row">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th style="text-align: center;"><h2>题目详情</h2></th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td><label class="form-control" style="height: 300px">
									<%=topics%>
							</label></td>
						</tr>
						<tr>
							<td>
								<div class="col-md-6">
									答案： <label class="form-control"
										style="width: 100%;height: 200px"> <%=answer%></label>
								</div>
								<div class="col-md-6">
									解析： <label class="form-control"
										style="width: 100%;height: 200px"><%=analysiss%></label>
								</div>
							</td>
						</tr>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary" id="sure">确认</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary" id="cancel">取消</button>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%
			} 
		%>

</body>
</html>