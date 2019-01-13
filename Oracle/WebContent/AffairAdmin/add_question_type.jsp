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
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="../QueryAllQuestionTypeServlet";
		});});
/* $(document).ready(function(){ 
	$("#sure").click(function(){	
		location.href="../AddQuestionTypeServlet";
		});}); */
</script>

<body>
<form action="/Oracle/AddQuestionTypeServlet" method="post">
    <div class="container">
     
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">题型号</th>
		      <th style="text-align: center;">题型名</th>
		     <!--  <th>所属课程</th> -->
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		         <input type="text" class="form-control" style="width: 100%;text-align: center;" id="Pronoun" name="Pronoun">
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%;text-align: center;" id="Meaning" name="Meaning">
		      </td>
 	       </tr>
		  </tbody>
     </table>
    </div> 
    
</div>
<br>
<div class="row">
        <!-- <div class="col-md-4"></div> -->
        
        
             <button type="submit"  id="sure">确认</button>
        
        
             <button type="button"  id="cancel">取消</button>
        
       
        <!-- <div class="col-md-4"></div> -->
    </div>
    </form>
</body>
</html>