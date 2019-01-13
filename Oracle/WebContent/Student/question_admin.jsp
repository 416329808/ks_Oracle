<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oracle.daomain.Questions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
<style>
table {
	table-layout: fixed;
}

td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="add_question.jsp";
		});});
</script>
</head>
<body>
   <div class="container">
     <div class="row">
        <div class="col-md-6">
            课程：
            <select name="course_select">
               <option value="1">--请选择--</option>
               <option value="11">操作系统</option>
               <option value="12">计算机组成原理</option>
               <option value="13">计算机网络</option>
            </select>
            章节：
            <select name="chapter_select">
               <option value="2">--请选择--</option>
               <option value="21">第一章</option>
               <option value="22">第二章</option>
               <option value="23">第三章</option>
            </select>
            题型：
            <select name="question_type_select">
               <option value="3">--请选择--</option>
               <option value="31">选择题</option>
               <option value="32">填空题</option>
               <option value="33">简答题</option>
            </select>
        </div>
      	<br/>       
        <div class="col-md-2">
            <input type="text" class="form-control" id="teaName" placeholder="请输入查询条件" style="width: 100%">
      	</div>
      	<div class="col-md-2">     
            <button class="btn btn-primary btn-sm" id="searchBtn">查询</button>
      	</div>

      	<div class="col-md-2">
           <button type="button" class="btn btn-primary" style="float: right;" id="add" onclick="location.href='AffairAdmin/add_question.jsp'">添加</button>
        </div>
        <div align="center" class="col-md-6">
        	<div class="col-md-2">     
            	<button class="btn btn-primary" id="cBtn" onclick="location.href='/Oracle/QuestionsinfoServlet?choice=choice&pageNum=1'">选择题</button>
      		</div>   
      		<div class="col-md-2">     
            	<button class="btn btn-primary" id="oBtn" onclick="location.href='/Oracle/QuestionsinfoServlet?pageNum=1'">others</button>
      		</div> 
		</div>
     <br/>
     <br/>
     <br/>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>序号</th>
		      <th>题目号</th>
		      <th>题目内容</th>
		      <th>分数</th>
		      <th>难度</th>
		      <th>题目类型</th>
		      <th>抽取次数</th>
		      <th>所属章节</th>
		      <th>所属课程</th>
		      <th>录入员工号</th>
		      <th>录入日期</th>
		      <th>操作</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:set var="a" value="${(pb.pageNum-1)*10+1}"></c:set>
		  	<c:forEach var="questionslist" items="${questionslist}" > 
		    <tr>
		      <td>${a}</td>
		      <td>${questionslist.getQuestionsID()}</td>
		      <td><a href="/Oracle/QuestionsinfoServlet?Style=${questionslist.getStyle()}&questionID=${questionslist.getQuestionsID()}">${questionslist.getTopics()}</a></td>
		      <td>${questionslist.getScore()}</td>
		      <td>${questionslist.getDifficult()}</td>
		      <td>${questionslist.getStyle()}</td>
		      <td>${questionslist.getExtractNum()}</td>
		      <td>${questionslist.getChapterName()}</td>
		      <td>${questionslist.getCourseName()}</td>
		      <td>${questionslist.getReporterID()}</td>
		      <td>${questionslist.getCreationDate()}</td>
		      <c:set var="a" value="${a+1}" />
		       <td><a href="/Oracle/QuestionsDeleteServlet?ID=${questionslist.getQuestionsID()}&style=${questionslist.getStyle()}">删除</a>|
		       <a href="/Oracle/QuestionsUpdateServlet?opertion=read&ID=${questionslist.getQuestionsID()}&style=${questionslist.getStyle()}&course_select=${questionslist.getCourseID()}&chapter_select=${questionslist.getChapterID()}" >修改</a></td>
 	       </tr>
 	         </c:forEach>
		 </tbody>
     </table>

          <%-- 构建分页导航 --%>
          <div align="center">
             <ul class="pagination">
        	<h4>共有${pb.totalRecord}个问题，共${pb.totalPage }页，当前为${pb.pageNum}页</h4>
            <li><a href="/Oracle/QuestionsinfoServlet?pageNum=1">首页</a></li>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${pb.pageNum ==1}">
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>                
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a></li>                                       
                    </c:if>                        
                </c:forEach>
                <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum+1}">下一页</a></li>                  
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${pb.pageNum > 1 && pb.pageNum < pb.totalPage}">
                <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">    
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>            
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a> </li>                                       
                    </c:if>                        
                </c:forEach>
                <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum+1}">下一页</a> </li>   
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${pb.pageNum == pb.totalPage}">
                <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a></li>                                       
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
           	<li><a href="/Oracle/QuestionsinfoServlet?pageNum=${pb.totalPage}">尾页</a></li>
  			</ul>
  		</div> 

  </div> 
</body>
</html>