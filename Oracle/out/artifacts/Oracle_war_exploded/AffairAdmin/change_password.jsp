<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
	<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="individual_info.jsp";
		});});
</script>
</head>
<body>
   <div class="container" style="text-align: center;height: 60%;">
      <br>
      <div class="row">
         <div class="col-md-12"> 
            <h3>旧密码：<input type="password" id="OldPsw" name="Olpsw"></h3>
         </div> 
      </div>
      <br>
      <div class="row"><div class="col-md-12"> <h3>新密码：<input type="password" id="New_PSW"></h3></div> </div>
      <br>
      <div class="row"> <div class="col-md-12"><h3>确认密码：<input type="password" id="New_PSW1"></h3></div> </div>
      <br>
      <div class="row">
      <div class="col-md-6">
      <button class="btn btn-default" value="确认" id="sure_btn" style="float: right;">确认</button>
   
      </div>
      <div class="col-md-6">
      <button class="btn btn-default" value="取消" id="cancel" style="float: left;">取消</button>
      </div>
   </div> 
   </div>
</body>
</html>