<%@page import="com.sunbeaminfo.sh.onlinefood.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%--
		LoginBean lb = new LoginBean();
		lb.setEmail(request.getParameter("email"));
		lb.setPass(request.getParameter("password"));
		if(lb.getStatus() == true)
			response.sendRedirect("categories.jsp");
		else {
			out.println("Invalid Login.<br/>");
			out.println("<a href='index.jsp'>Login Again<br/>");
		}
	--%>
	
	<jsp:useBean id="lb" class="com.sunbeaminfo.sh.onlinefood.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="pass" param="password"/>
	
	<%-- ${lb.getStatus()} --%>
	
	<% if(lb.getStatus() == true) { %>
		<jsp:forward page="categories.jsp"/>
	<% } else { %>
		Sorry, <jsp:getProperty name="lb" property="email"/> <br/>
		Invalid Login.<br/>
		<a href='index.jsp'>Login Again<br/>
	<% } %>
</body>
</html>
