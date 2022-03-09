<%@page import="entities.Cliente"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Pedido</title>
<%LinkedList<Cliente> lista = (LinkedList<Cliente>)request.getAttribute("lista");  %>
</head>
<body>
<h2>Seleccionar Cliente</h2>
<form action="pedido" method=post>
<TABLE>
<thead>
                    			<tr>
                    				<th>id</th>
                    		    	<th>dni</th>
                    		    	<th>apellido</th>
                        			<th>nombre</th>
                        			<th>email</th>
                        			<th>direccion</th>
                        			<th>tel</th>
                        			<th></th>
                      			</tr>
                      		</thead>
                            <tbody>
                    		<% for (Cliente cli : lista) { %>
                    			<tr>
                    				<td><%=cli.getId() %></td>
                    				<td><%=cli.getDni() %></td>
                    				<td><%=cli.getApellido() %></td>
                    				<td><%=cli.getNombre() %></td>
                    				<td><%=cli.getEmail() %></td>
                    				<td><%=cli.getDireccion() %></td>
                    				<td><%=cli.getTel() %></td>
                    				<td><INPUT NAME="cliente" TYPE=radio VALUE=<%=cli.getId() %>></td>
                    				<% } %>
                    				</TABLE>
                    				<input type="submit" value="Aceptar">
                    				</form>
</body>
</html>