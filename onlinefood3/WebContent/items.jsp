<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items</title>
</head>
<body>
	<jsp:useBean id="cb" scope="session" class="com.sunbeaminfo.sh.onlinefood.beans.CartBean"/>

	<jsp:useBean id="ib" class="com.sunbeaminfo.sh.onlinefood.beans.CategoryItemsBean"/>
	<jsp:setProperty name="ib" property="*" />
	${ib.execute()}
	<form method="post" action="addcart.jsp">
		<table>
		<c:forEach var="item" items="${ib.itemList}" varStatus="status">
			<tr>
				<td>
					o
				</td>
				<td>
					${item.name}
				</td>
				<td> 
					<input type="number" min="0" max="10" style="width: 35px" name="qty_${item.id}" value="${cb.getQuantity(item.id)}"/>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br/>
		<input type="submit" value="Add Cart"/>
	</form>
</body>
</html>
