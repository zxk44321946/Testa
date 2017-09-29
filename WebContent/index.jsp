<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="post" method="post" action ="TestServlet">
<p>
<label for="username"></label>用户名：
<input type="text" name="username" id ="username">
</p>
<p>
<label for="password"></label>密	   码：
<input type="text" name="password" id ="password">
</p>
<p>
<a href="register.jsp">注册</a>
<input type ="submit" value="登录">
</p>
</form>
</body>
</html>



