<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
	<h4>Categories</h4>
	<%--
	<jsp:useBean id="lb" class="com.sunbeaminfo.sh.onlinefood.beans.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="email"/> <br/>
	--%>
	Hello, ${lb.email} <br/>
	 
	<form method="post" action="items.jsp">
		<input type="submit" value="Show Items"/>
	</form>
</body>
</html>

