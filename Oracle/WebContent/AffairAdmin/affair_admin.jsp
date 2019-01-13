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
          String BusinessPersonID=(String)request.getAttribute("account");
         if(BusinessPersonID!=null){
           %>
<script type="text/javascript">
	
	function myinfo(){
		window.location.href="/Oracle/BusinessAdminsinfoServlet?BusinessPersonID="+<%=BusinessPersonID%>;
	}
	
	
	</script>
<script type="text/javascript">
	function tishi(){
	<% if ("".equals(message) || message == null) {
				} else {%>

        alert("<%=message%>");        
 
<%}%>
}
</script>
</head>
<body>
<div class="container-fluid">
	   <div class="row" style="height: 90px;background-color:#CE8483;">
			<div class="col-md-6">
		          <img src="image/new_logo2.png">
		    </div>
		    <div class="col-md-6"></div>
	  </div>
	  	  
	 <!--  导航栏元素	  -->
	 <div class="row">
		 <div class="col-md-12">
			<ul class="nav nav-tabs nav-pills nav-justified">
			    <li class="active"><a data-toggle="tab" href="#home">首页</a></li>
			    <li><a data-toggle="tab" href="#menu1">个人信息</a></li>
			    <li><a data-toggle="tab" href="#menu2">课程管理</a></li>
			    <li><a data-toggle="tab" href="#menu3">章节管理</a></li>
			    <li><a data-toggle="tab" href="#menu4">题型管理</a></li>
			    <li><a data-toggle="tab" href="#menu5">题目管理</a></li>
			</ul>
			<div class="tab-content">
			    <div id="home" class="tab-pane fade in active">
			       <iframe src="AffairAdmin/head.jsp" frameborder="0" style="width: 100%;height: 100%;" scrolling="no"></iframe>
			    </div>
			    <div id="menu1" class="tab-pane fade">
			      <iframe src="/Oracle/BusinessAdminsinfoServlet?BusinessPersonID=<%=BusinessPersonID %>" frameborder="0" style="width: 100%;height: 900px;" scrolling="no"></iframe>
			    </div>
			    <div id="menu2" class="tab-pane fade">	
			        <iframe src="/Oracle/QueryAllCourseServlet" frameborder="0" style="width: 100%;height: 520px;" ></iframe>		      
			    </div>
			    <div id="menu3" class="tab-pane fade">	
			        <iframe src="/Oracle/ChapterinfoServlet?pageNum=1" frameborder="0" style="width: 100%;height: 520px;" ></iframe>		      
			    </div>
			    <div id="menu4" class="tab-pane fade">	
			        <iframe src="/Oracle/QueryAllQuestionTypeServlet" frameborder="0" style="width: 100%;height: 520px;" ></iframe>		      
			    </div>
			    <div id="menu5" class="tab-pane fade">	
			        <iframe src="/Oracle/QuestionsinfoServlet?pageNum=1" frameborder="0" style="width: 100%;height: 520px;" ></iframe>			      
			    </div>
			</div>
							<%
         }
	
	%>
	     </div>
	  </div>	  
   </div>
</body>
</html>