<%@page import="java.util.List,com.maven.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table width="880" border="1" cellspacing="0" cellpadding="0">
  <tr>
  <td width="65dp">电影编号</td>
  <td>名称</td>
  <td>描叙</td>
  <td>语言</td>
  <td width="35dp">新增</td>
  <td width="35dp">删除</td>
  <td width="35dp">编辑</td>
  </tr>
   <c:forEach items="${data}" var="item" varStatus="">
    <tr>
	  <td>${item.filmId}</td>
	  <td>${item.title }</td>
	  <td>${item.description }</td>
	  <td>${item.language.name}</td>
	  <td><a href="MapServlet.action"> 新增    </a></td>
	  <td><a href="FilmServlet.action?type=delete"> 删除    </a></td>
	  <td><a href="FilmServlet.action?type=update&uid=${item.filmId}"> 编辑    </a></td>
	 
	  </tr>
   </c:forEach>
	 

  </table>
  </div>

</body>
</html>