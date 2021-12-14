<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String admin; %>
<%
if(session.getAttribute("admin") == null){
	response.sendRedirect("Login.html");
}else{
admin = session.getAttribute("admin").toString();
}
%>
welcome : <%=admin %>
</body>
</html>