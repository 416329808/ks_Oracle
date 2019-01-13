<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page import="com.oracle.daomain.QuestionTypeChapter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>章节管理</title>
 <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
function Update_sure(){
    var gnl=confirm("确定修改该课程信息?");
    if (gnl==true){
      return true;
    }else{
       return false;
   }
 };
 
 function Delete_sure(){
     var gnl=confirm("确定删除该课程信息?");
     if (gnl==true){
       return true;
     }else{
        return false;
    }
  };

</script>
</head>
<body>
     <br>
     <%
          int i=1;
           %>
   <div class="container">
     <div class="row">
        <div class="col-md-10">
            <select name="chapter_select">
               <option value="0">--请选择--</option>
               <option value="1">操作系统</option>
               <option value="2">计算机组成原理</option>
               <option value="3">计算机网络</option>
            </select>
        </div>
        <div class="col-md-2">
           <button type="button" class="btn btn-primary" style="float: right;" id="add" onclick="location.href='AffairAdmin/add_chapter.jsp'">添加</button>
        </div>
     </div>
     <br>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>序号</th>
		      <th>章节号</th>
		      <th>章节名</th>
		      <th>所属课程</th>
		      <th>包含题型</th>
		      <th>题目数</th>
		      <th>操作</th>
		    </tr>
		  </thead>
		  <tbody>	
		    <c:set var="a" value="${(pb.pageNum-1)*10+1}"></c:set>	  
			<c:forEach var="questionchapterList" items="${pb.getList()}" > 
		    <tr>
		      <td>${a}</td>
		      <td>${questionchapterList.getChapterID()}</td>
		      <td>${questionchapterList.getChapterName()}</td>
		      <td>${questionchapterList.getCourseID()}</td>
		      <td>${questionchapterList.getMeaning()}</td>
		      <td>${questionchapterList.getProblemNumber()}</td>
		      <c:set var="a" value="${a+1}"></c:set>
		      <td><a href="/Oracle/ChapterdeleteServlet?ChapterID='${questionchapterList.getChapterID()}'&Meaning='${questionchapterList.getMeaning()}'&CourseID='${questionchapterList.getCourseID()}'" onclick="return Delete_sure()">删除</a>|<a href="/Oracle/ChapterUpdateServlet?&ChapterID='${questionchapterList.getChapterID()}'&Meaning='${questionchapterList.getMeaning()}'&CourseID='${questionchapterList.getCourseID()}'&ChapterName='${questionchapterList.getChapterName()}'&ProblemNumber='${questionchapterList.getProblemNumber()}'" onclick="return Update_sure()">修改</a></td>
 	       </tr>
 	         </c:forEach>

		  </tbody>
     </table>
              <%-- 构建分页导航 --%>
          <div align="center">
             <ul class="pagination">
        	<h4>共有${pb.totalRecord}个章节，共${pb.totalPage }页，当前为${pb.pageNum}页</h4>
            <li><a href="/Oracle/ChapterinfoServlet?pageNum=1">首页</a></li>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${pb.pageNum ==1}">
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>                
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/ChapterinfoServlet?pageNum=${i}">${i}</a></li>                                       
                    </c:if>                        
                </c:forEach>
                <li><a href="/Oracle/ChapterinfoServlet?pageNum=${pb.pageNum+1}">下一页</a></li>                  
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${pb.pageNum > 1 && pb.pageNum < pb.totalPage}">
                <li><a href="/Oracle/ChapterinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">    
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>            
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/ChapterinfoServlet?pageNum=${i}">${i}</a> </li>                                       
                    </c:if>                        
                </c:forEach>
                <li><a href="/Oracle/ChapterinfoServlet?pageNum=${pb.pageNum+1}">下一页</a> </li>   
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${pb.pageNum == pb.totalPage}">
                <li><a href="/Oracle/ChapterinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
                <c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
                    <c:if test="${pb.pageNum == i}">
                        <li><a href="#">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.pageNum != i}">
                        <li><a href="/Oracle/ChapterinfoServlet?pageNum=${i}">${i}</a></li>                                       
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
           	<li><a href="/Oracle/ChapterinfoServlet?pageNum=${pb.totalPage}">尾页</a></li>
  			</ul>
  		</div> 
     
  </div> 

</body>
</html>