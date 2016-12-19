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
    <h2>新增页面</h2>  
    <form action="FilmServlet.action?type=add"method="post">  
       title：&nbsp; &nbsp;<input type="text" name="title"><br/><br/> 
    
    description：<input type="text" name="description"><br/><br/> 
     language：<select name ="selectLanguage" style="width:180px;">
                   <option selected>select language</option>
                   	<c:forEach items="${mapdata}" var="map">
						<option value="${map.key}">${map.value}</option>
	                </c:forEach>
    </select>
    <input type="submit" value="提交">  
    </form>  
    </div>  
    </center> 

</body>
</html>