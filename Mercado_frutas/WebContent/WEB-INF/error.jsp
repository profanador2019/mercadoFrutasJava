<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h4><%=request.getAttribute("mensaje") %></h4>
<a href="<%=request.getAttribute("direccion-volver") %>">
<br><%=request.getAttribute("mensaje-volver") %>
</a>
</body>
</html>