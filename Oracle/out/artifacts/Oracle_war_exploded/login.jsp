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

</head>
<script>




/* function jump(){
	window.open("");
} */

$(function(){
	
	$("#submitBtn").click(function(){
		
		if($("#firstname").val()==""){
			alert("请输入账号");
			
		}else if($("#password").val()==""){
			//alert("请输入密码");
			
		}else{
			window.location.href = 'Student.jsp';
			var firstnam = $("#firstname").val();
			var password=$("#password").val();
			
			$.ajax({				
				type: "post",
				url: "${basePath}/LoginServlet?method=login",
				data:{firstnam:firstnam,password:password}, 
				dataType: "json", //返回数据类型
				success: function(msg){
					
					 if("loginError" == msg){
						alert("用户名或密码错误!");	
					} else if("student" == msg){
						var ID=$("#firstname").val();
						window.location.href = "CheckServlet?method=tostudent&"+"ID="+ID;
					} else if("teacher" == msg){
						var ID=$("#firstname").val();
						window.location.href = "CheckServlet?method=toteacher&"+"ID="+ID;
					} else if("AffairAdmin" == msg){
						var ID=$("#firstname").val();
						window.location.href = "CheckServlet?method=toAffairAdmin&"+"ID="+ID;
					}else if("systemAdmin" == msg){
						var ID=$("#firstname").val();
						window.location.href = "CheckServlet?method=tosystemAdmin&"+"ID="+ID;
					}
				}
				
			});
		}

	
	});
});
</script>
<body>
	<div class="container-fluid"
		style="background-image: url('image/20171004175021_F2Cd3.jpeg');">
		<div class="row" style="height: 180px">&nbsp;</div>
		
		<div class="row">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-4">
				<form  id="form" name="form" class="form-horizontal" action=""  method="post">
					<div class="form-group">
						<label for="firstname" class="col-sm-6 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="firstname"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-6 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-6 col-sm-12">
							<button type="submit" id="submitBtn"  name="submitBtn" class="btn btn-default" ">登录</button>
						</div>
					</div>
				</form>
				<div class="col-md-5">&nbsp;</div>
			</div>
		</div>
</body>
</html>