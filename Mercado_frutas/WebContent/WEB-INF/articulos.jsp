<%@page import="entities.Articulo"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir articulo</title>
<% LinkedList<Articulo> lista = (LinkedList<Articulo>)request.getAttribute("listaarticulos"); %>
</head>
<body>
<h2>Añadir Articulo/s</h2>
<form action="añadir" method=post>
<TABLE>
<thead>
                    			<tr>
                    				<th>id</th>
                    		    	<th>nombre</th>
                    		    	<th>descripcion</th>
                        			<th>cant_aprox_kg</th>
                        			<th>precio_sugerido</th>
                        			<th></th>
                      			</tr>
                      		</thead>
                            <tbody>
                    		<% for (Articulo art : lista) { %>
                    			<tr>
                    				<td><%=art.getId_articulo() %></td>
                    				<td><%=art.getNombre() %></td>
                    				<td><%=art.getDescripcion() %></td>
                    				<td><%=art.getCant_aprox_kg() %></td>
                    				<td><%=art.getPrecio_sugerido() %></td>
                    				<td><INPUT id="articulo" NAME="articulo" TYPE=radio VALUE=<%=art.getId_articulo() %>></td>
                    				<% } %>
                    				</TABLE>
                    				cantidad<input id="cantidad" name="cantidad" type=text size=10>
                    				precio<input id="precio" name="precio" type=text size=10>
                    				<input type="submit" value="Añadir">
                    				</form>
                    	<form action="finalizar" method=post>
                    	cantidad bultos<input id="cantidadbultos" name="cantidadbultos" type=text size=10>
                    	<input type="submit" value="Finalizar pedido"></form>			
</body>
</html>