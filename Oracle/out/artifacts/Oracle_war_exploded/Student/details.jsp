<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="question_admin.jsp";
		});});
</script>
<body>
<div class="container">
<div class="row">
  <table class="table table-condensed">
  <thead>
    <tr>
      <th>
	      <div class="col-md-4"></div>
	      <div class="col-md-4">
	        <h2 style="text-align: center;">题目详情</h2>
	      </div>
	      <div class="col-md-4">
	        <a href="search_question.jsp" style="float: right;line-height: 60px;">返回</a>
	      </div>
      </th>  
     </tr>
  </thead>
	  <tbody>
	    <tr>
	      <td>
	        <label class="form-control" style="height: 300px">			      
			</label>
	      </td>
	    </tr>
	    <tr>
	      <td>
	      <div class="col-md-6" >答案：
	         <label class="form-control" style="width: 100%;height: 200px"> </label>
	         </div>
	      <div class="col-md-6">解析：
	         <label  class="form-control" style="width: 100%;height: 200px"></label> </div>
	      </td>	      
	    </tr>    
	  </tbody>
  </table>
  	</div>
</div>
</body>
</html>