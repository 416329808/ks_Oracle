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
	<script type="text/javascript">
	   function cancel_collection(){
		   var f=confirm("确定要取消收藏吗？");
			if(f) return true;
			else return false;
	   };
	</script>
</head>
<body>
    <table class="table">
	  <caption style="text-align: center;"><h3>收藏试卷</h3></caption>
	  <thead>
	    <tr>
	      <th style="text-align: center;">序号</th>
	      <th style="text-align: center;">试卷号</th>
	      <th style="text-align: center;">详情</th>
	      <th style="text-align: center;">建立日期</th>
	      <th style="text-align: center;">操作</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%for(int i=0;i<=4;i++) {%>
	    <tr>
	      <td style="text-align: center;">1</td>
	      <td style="text-align: center;">001</td>
	      <th style="text-align: center;"><a href="paper_details.jsp">点击查看收藏试卷详情</a></th>
	      <th style="text-align: center;">2018/11/28</th>
	      <th style="text-align: center;"><a href="#" onclick="return cancel_collection()">取消收藏</a></th>
	    </tr>
	    <%} %>
  </tbody>
</table>
</body>
</html>