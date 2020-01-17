<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Cart</title>
</head>
<body>
	<jsp:useBean id="cb" scope="session" class="com.sunbeaminfo.sh.onlinefood.beans.CartBean"/>
	<c:forEach var="p" items="${param}">
		<c:if test="${fn:startsWith(p.key, 'qty') && p.value != '0'}">
			${cb.addToCart(fn:substringAfter(p.key, 'qty_'), p.value)}			
		</c:if>
	</c:forEach>
	<jsp:forward page="categories.jsp"/>
</body>
</html>

