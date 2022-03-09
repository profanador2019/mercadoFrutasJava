<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Total</title>
<%double total = (double)request.getAttribute("total"); %>
</head>
<body>
El total de su pedido es <%=total %>
<a href="finalizar">Aceptar</a>
</body>
</html>