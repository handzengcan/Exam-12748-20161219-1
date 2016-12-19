<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
 <center>  
    <div>  
    <h2>登录页面</h2>  
    <form action="LoginServlet.action?type=login" method="post">  
    请输入用户名：<input type="text" name="username"><br/><br/> 
    
    请输入密码：  &nbsp; <input type="password" name="password"><br/><br/>   
    <input type="submit" value="登录">  
    </form>  
    </div>  
    </center>  
  </body>  

</body>
</html>