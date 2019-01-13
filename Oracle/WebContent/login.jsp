<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
 String message=(String)request.getAttribute("message");
 String account=(String)request.getAttribute("account");
 String type=(String)request.getAttribute("type");
    if("".equals(message)||message==null){        
    }
 else if("登陆成功".equals(message)){%>
<script type="text/javascript">
        alert("<%=message%>"); 
        window.location.href="/Oracle/CheckServlet?type="+<%=type%>+"&account="+<%=account%>;      
</script>  
<% 		
	
}else{
%>
	<script type="text/javascript">
        alert("<%=message%>");
        window.location.href="login.jsp";        
</script> 
<%}%>

</head>
<script>
	/* function jump(){
		window.open("");
	} */

	$(function() {

		$("#submitBtn").click(function() {

			if ($("#firstname").val() == "") {
				alert("请输入账号");
				return false;

			} else if ($("#password").val() == "") {
				alert("请输入密码");
				return false;

			} else {
				return true;
			}


		});
	});
</script>
<body style="background-image: url('image/20171004175021_F2Cd3.jpeg');">
	<div class="container-fluid"
		>
		<div class="row" style="height: 180px">&nbsp;</div>

		<div class="row">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-4">
				<form id="form" name="form" class="form-horizontal"
					action="/Oracle/LoginServlet" method="post">
					<div class="form-group">
						<label for="firstname" class="col-sm-6 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="firstname" id="firstname"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-6 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" name="password"  id="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-6 col-sm-12">
							<button type="submit" id="submitBtn" name="submitBtn"
								class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
				<div class="col-md-5">&nbsp;</div>
			</div>
		</div>
	</div>
</body>
</html>