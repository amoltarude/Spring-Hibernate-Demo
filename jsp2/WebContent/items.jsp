<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items</title>
</head>
<body>
	<h4>Items</h4>
	<jsp:useBean id="lb" class="com.sunbeaminfo.sh.onlinefood.beans.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="email"/> <br/>
	
	<form method="post" action="addcart.jsp">
		<input type="submit" value="Add Cart"/>
	</form>
</body>
</html>

