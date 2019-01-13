<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oracle.daomain.checkperson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancel").click(function() {
			location.href = "individual_info.jsp";
		});
	});
	$(function() {
		$('#sure_btn')
				.click(
						function() {
							var OldPswValue = $('#OldPsw').val();

							var NewPswValue = $('#New_PSW').val();

							var NewPsw1Value = $('#New_PSW1').val();

							if (OldPswValue == ""
									|| NewPswValue == ""
									|| NewPsw1Value == ""){
								alert("抱歉，请填写完所有信息！");
								return false;
							}
							if (NewPswValue！=NewPsw1Value) {
								alert("两次密码不符");
								return false;
							}
						});
	});
	});
</script>
<%
    String mess=(String)request.getAttribute("message");
    if("".equals(mess)  ||mess==null){        
    }
 else{%>
    <script type="text/javascript">
        alert("<%=mess%>");
        
</script>  
<% }%>
</head>
<body>
	<form id="form" name="form" class="form-horizontal"
		action="/Oracle/change_passwordServlet" method="post">
		<%
		checkperson person = (checkperson) request.getAttribute("checkperson");
		String ID = "";
		String pwd = "";
		if (person != null) {
			ID = person.getAccounts();
			pwd = person.getPasswords();
		}
			%>
		<div class="container" style="text-align: center; height: 60%;">
			<br> <input type="hidden" id="ID" name="ID" value=<%=ID %>></input>
			<input type="hidden" id="pwd" name="pwd" value=<%=pwd %>></input>
			<div class="row">
				<div class="col-md-12">
					<h3>
						旧密码：<input type="password" id="OldPsw" name="OldPsw">
					</h3>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12">
					<h3>
						新密码：<input type="password" id="New_PSW" name="New_PSW">
					</h3>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12">
					<h3>
						确认密码：<input type="password" id="New_PSW1" name="New_PSW1">
					</h3>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-6">
					<button class="btn btn-default" type="submit" value="确认"
						id="sure_btn" style="float: right;">确认</button>
				</div>
				<div class="col-md-6">
					<button class="btn btn-default" value="取消" id="cancel"
						style="float: left;">取消</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>