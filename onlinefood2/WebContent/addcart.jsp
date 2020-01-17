<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Cart</title>
</head>
<body>
	<jsp:useBean id="cartBean" class="com.sunbeaminfo.sh.onlinefood.beans.CartBean" scope="session"/>
	<jsp:setProperty name="cartBean" property="itemIds" param="item"/>
	${cartBean.addToCart()}
	<jsp:forward page="categories.jsp"/>
</body>
</html>

