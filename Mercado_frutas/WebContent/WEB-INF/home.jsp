<%@page import="entities.Personal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%Personal p = (Personal)session.getAttribute("usuario"); %>
</head>
<body>
<h2><b><font color=green>Bienvenido <%=p.getNombre() %> <%=p.getApellido() %></font></b></h2>
<h2>Menu</h2>
<menu>
<LI><a href="nuevopedido"><font size=4>Nuevo pedido</font></a>
<LI><a href="recientes"><font size=4>Pedidos Recientes</font></a>
<LI><a href="index.html"><font size=4>Salir</font></a>
</menu>

</body>
</html>