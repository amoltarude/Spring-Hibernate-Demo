<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="food" uri="/WEB-INF/onlinefood-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<h3>Cart</h3>
	Hello, ${lb.name} <hr/>
	<c:set var="total" value="0.0"/>
	<table border="1">
		<tr style="background-color: gray;">
			<td>Id</td>
			<td>Category</td>
			<td>Name</td>
			<td>Price</td>
		</tr>
		<c:forEach var="id" items="${cartBean.cart}">
			<food:showitem id="${id}"/>
			<c:set var="total" value="${total + price}"/>
		</c:forEach>
	</table>
	Total Bill: Rs. ${total}/-
	<br/><br/>
	<a href="ctl?page=logout">Sign Out</a>
</body>
</html>


