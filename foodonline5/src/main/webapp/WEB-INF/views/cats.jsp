<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
	<h3>Categories</h3>
	Hello, ${lb.name} <hr/>
	<jsp:useBean id="cb" class="com.sunbeaminfo.sh.onlinefood.beans.CategoryBean"/>
	${cb.fetchCategories()}
	<form method="post" action="ctl?page=items">
		<c:forEach var="cat" items="${cb.categoryList}">
			<input type="radio" name="category" value="${cat}"/>${cat}<br/>
		</c:forEach>
		<input type="submit" value="Show Items"/>
		<a href="ctl?page=showcart">Show Cart</a>
	</form>
	
</body>
</html>

