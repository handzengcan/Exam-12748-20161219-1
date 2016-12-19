<%@page import="com.mysql.fabric.Response"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>  
    <div>  
    <h2>编辑页面</h2>  
    <form action="FilmServlet.action?type=updateNew&id=${filmdata.filmId}" method="post">  
       title：&nbsp; &nbsp;<input type="text" name="title1" value="${filmdata.title}"><br/><br/> 
    description：<input type="text" name="description1" value="${filmdata.description}"><br/><br/> 
     language：
     
     <select name ="selectLanguageNew" style="width:180px;">
                   <option selected>${filmdata.language.name}</option>
                   	<c:forEach items="${maps}" var="map">
						<option value="${map.key}">${map.value}</option>
	                </c:forEach>
    </select>
     
    <input type="submit" value="提交">  
    </form>  
    </div>  
    </center> 


</body>
</html>