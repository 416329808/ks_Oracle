<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oracle.daomain.checkperson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
	<script type="text/javascript">
	 $(document).ready(function() {
		$("#cancel").click(function() {
			location.href = "individual_info.jsp";
		});
	});
	 
	
	$(function(){
		$('#sure_btn').click(function(){
			
			  var oldpsw=$("#OldPsw").val();
	 		  var psw=$("#New_PSW").val();
	 	      var psw1=$("#New_PSW1").val();
		      
	 	      if(oldpsw==""){
	 	    	  alert("请输入原密码");
	 	    	  return false;
	 	      }else if(psw==""||psw1==""){
	 	    	  alert("请输入新密码");
	 	    	 return false;
	 	      }else if(psw!=psw1){
	 	    	  alert("两次密码输入不一致");
	 	    	 return false;
	 	      }else if($("#New_PSW").val().length<5||$("#New_PSW").val().length>15){
	 	    	  alert("密码长度必须大于6小于15");	
	 	    	 return false;
	 	      }	
	 	      
	 	        return true;
		});
		});
	
	

	</script>
</head>
<%
		checkperson c = (checkperson) request.getAttribute("c");      
		if (c != null) {
			String Accounts = c.getAccounts();
			String Passwords = c.getPasswords();
			String Style = c.getStyle();
	%>
<body>
	<form id="form" name="form" class="form-horizontal"
		action="/Oracle/changeAdminpasswordServlet" method="post">
		<div class="container" style="text-align: center; height: 60%;">
			<div class="row">
				<div class="col-md-12">
					<h3>
						账号：<input type="text" id="account" name="account" value=<%=c.getAccounts()%> readonly>
					</h3>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12">
					<h3>
						旧密码：<input type="password" id="OldPsw" name="OldPsw" >
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
<%
						}
					%>
</html>