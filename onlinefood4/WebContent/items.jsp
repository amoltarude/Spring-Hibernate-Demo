<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items</title>
</head>
<body>
	<h3>Items</h3>
	Hello, ${lb.name} <hr/>

	<jsp:useBean id="ib" class="com.sunbeaminfo.sh.onlinefood.beans.CategoryItemsBean"/>
	<jsp:setProperty name="ib" property="*"/>
	${ib.fetchCategoryItems()}
	<form method="post" action="ctl?page=addcart">
		<c:forEach var="item" items="${ib.itemList}">
			<input type="checkbox" name="item" value="${item.id}"/>${item.name} <br/>
		</c:forEach>
		<input type="submit" value="Add To Cart"/>
	</form>
</body>
</html>



