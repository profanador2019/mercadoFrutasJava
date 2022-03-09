<%@page import="entities.Pedido"%>
<%@page import="entities.Articulo"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos recientes</title>
<% LinkedList<Pedido> lista = (LinkedList<Pedido>)request.getAttribute("lista"); %>
</head>
<body>
<h2>Pedidos Recientes</h2>
<form action="despachar" method=post>
<TABLE>
<thead>
                    			<tr>
                    				<th>nro</th>
                    		    	<th>fecha y hora</th>
                    		    	<th>cantidad de bultos</th>
                        			<th>cliente</th>
                        			<th>vendedor</th>
                        			<th>abonado</th>
                        			<th>fecha abonado</th>
                        			<th>retirado</th>
                        			<th></th>
                      			</tr>
                      		</thead>
                            <tbody>
                    		<% for (Pedido p : lista) { %>
                    			<tr>
                    				<td><%=p.getNro_pedido() %></td>
                    				<td><%=p.getFecha_pedido().toString() %></td>
                    				<td><%=p.getCant_bultos() %></td>
                    				<td><%=p.getCliente().getApellido() %></td>
                    				<td><%=p.getVendedor().getNombre() %></td>
                    				<td><%=p.isAbonado() %></td>
                    				<td><%=(p.getFecha_abonado()==null)?null:p.getFecha_abonado().toString() %></td>
                    				<td><%=p.isRetirado() %></td>
                    				<td><INPUT id="pedido" NAME="pedido" TYPE=radio VALUE=<%=p.getNro_pedido() %>></td>
                    				<% } %>
                    				</TABLE>
                    				abonado<input id="estado" name="estado" type=radio value="abonado" >
                    				despachar<input id="estado" name="estado" type=radio value="retirado">
                    				<input type="submit" value="Aplicar">
                    				</form>
                    				
                    				
</body>
</html>