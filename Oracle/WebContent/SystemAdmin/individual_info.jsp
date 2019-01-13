<%@page import="com.oracle.daomain.Admin"%>
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
		Admin admin = (Admin) request.getAttribute("admin");
        String ID=(String) request.getAttribute("ID");
		if (admin != null) {
			String AdminsID = admin.getAdminsID();
			String AdminsName = admin.getAdminsName();
			String Sex = admin.getSex();
	%>
	<script type="text/javascript">
	
	function update(){
		window.location.href="changeAdminWordList?ID="+<%=admin.getAdminsID()%>;
	}
	
	</script>
</head>
<body>

    <div class="container-fluid">
      <div class="row" style="text-align: center;font-size: 40px">我的信息</div>
      <br>
      <br>
      <div class="row" >
         <div class="col-md-3"> </div>
         <div class="col-md-6" style="text-align: center">
            <form class="form-horizontal" role="form">
	           <div class="form-group">
		         <label for="no" class="col-md-2 control-label">工号:</label>
		         <div class="col-md-8">
			     <input type="text" class="form-control" id="no" style="border-style: none"  value=<%=AdminsID%> readonly>
		       </div>
	           </div>
	           <br>
           <div class="form-group">
		   <label for="lastname" class="col-md-2 control-label">姓名:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="lastname" style="border-style: none" value=<%=AdminsName%> readonly >
		     </div>
	     </div>
	     <br>
	     <div class="form-group">
		     <label for="class" class="col-md-2 control-label">性别:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="class" style="border-style: none" value=<%=Sex%> readonly>
		     </div>
	     </div>
       </form>
       <form role="form" id="form" name="form" method="post">
       <br>
      <div class="form-group">      
        <!-- <button type="button" class="btn btn-link"><font color="red" size="5px">修改密码</font></button>      -->
         <input type="button" class="btn btn-primary"  value="修改密码"  onclick="update()" >
         
      </div>
      <%
						}
					%>
      </form>        
    </div>
      </div>
   </div>
</body>
</html>