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
		location.href="question_type_admin.jsp";
		});});
</script>

<body>
    <div class="container">
     
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>题型号</th>
		      <th>题型名</th>
		      <!-- <th>所属课程</th> -->
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		         <input type="text" class="form-control" style="width: 100%">
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%">
		      </td>
		      <!-- <td>
		        <select name="chapter_select">
               <option value="0">--请选择--</option>
               <option value="1">操作系统</option>
               <option value="2">计算机组成原理</option>
               <option value="3">计算机网络</option>
            </select>
		      </td> -->
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
</body>
</html>