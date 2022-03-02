package data;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.*;

public class DataPedido {
	
	public void savePedido(Pedido p) {
		PreparedStatement stmt = null;
		ResultSet krs = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("insert into pedido"
							+"(fecha_pedido,cant_bultos,id_cliente,dni_personal) "
							+ "values (?,?,?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setObject(1,p.getFecha_pedido());
			stmt.setInt(2,p.getCant_bultos());
			stmt.setInt(3,p.getCliente().getId());
			stmt.setInt(4,p.getVendedor().getDni());
			
			stmt.executeUpdate();
			
			krs = stmt.getGeneratedKeys();
			if(krs!=null && krs.next()) {
				p.setNro_pedido(krs.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(krs!=null) {krs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace(); // hacer save lineas(art_pedido)
			}
		}
	}
	
	public void saveArticulosPedidos(Pedido p) {
		PreparedStatement stmt = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("insert into "
							+ "articulo_pedido(id_articulo,nro_pedido,cantidad) "
							+ "values(?,?,?)");
			
			for(LineaPedido linea: p.getLineas()) {
				stmt.setInt(1,linea.getArticulo().getId_articulo());
				stmt.setInt(2,p.getNro_pedido());
				stmt.setInt(3,linea.getCantidad());
				stmt.addBatch();
			}
			stmt.executeBatch();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public LinkedList<Pedido> getPedidosRecientes(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DataCliente dc = new DataCliente();
		DataPersonal dv = new DataPersonal();
		LinkedList<Pedido> pedidos = new LinkedList<>();
		try {
			stmt=DBConnector.getInstancia().getConn()
					.prepareStatement("select * from pedido where date(fecha_pedido)='?'");
			stmt.setObject(1,LocalDate.now());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Pedido p = new Pedido();
					p.setNro_pedido(rs.getInt("nro_pedido"));
					p.setFecha_pedido(rs.getObject("fecha_pedido", LocalDateTime.class));
					p.setCant_bultos(rs.getInt("cant_bultos"));
					p.setAbonado(rs.getBoolean("abonado"));
					p.setFecha_abonado(rs.getObject("fecha_abonado",LocalDateTime.class));
					p.setRetirado(rs.getBoolean("retirado"));
					
					dc.setCliente(p);
					dv.setPersonal(p);
					this.setLineas(p);
					
					pedidos.add(p);
				}
			}
					
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} return pedidos;
	}
	
	
	public void setLineas(Pedido p) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<LineaPedido> lineas = new LinkedList<>();
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("select * "
							+ "from pedido natural join articulo_pedido "
							+ "natural join articulo "
							+ "where nro_pedido=?");
			
			stmt.setInt(1,p.getNro_pedido());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Articulo a = new Articulo();
					LineaPedido l = new LineaPedido();
					
					a.setId_articulo(rs.getInt("id_articulo"));
					a.setNombre(rs.getString("nombre"));
					a.setPrecio(rs.getDouble("precio"));
					
					l.setCantidad(rs.getInt("cantidad"));
					l.setArticulo(a);
					
					lineas.add(l);
					
				} p.setLineas(lineas);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
