<%@page import="com.sunbeaminfo.sh.onlinefood.beans.LoginBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeaminfo.sh.onlinefood.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="pass" param="password"/>
	<c:choose>
		<c:when test="${lb.getStatus() == true}">
			<c:redirect url="categories.jsp"/>
		</c:when>
		<c:otherwise>
			Sorry, ${lb.email} <hr/>
			Invalid Login.<br/>
			<a href='index.jsp'>Login Again<br/>			
		</c:otherwise>
	</c:choose>
</body>
</html>
