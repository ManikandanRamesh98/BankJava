<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Sucessfully!!</title>
</head>
<body>
<%!String reguser; %>
<%reguser = session.getAttribute("reguser").toString(); %>
<h1>User <%=" " +reguser+" " %>Registered Sucessfully!!</h1>
</body>
</html>