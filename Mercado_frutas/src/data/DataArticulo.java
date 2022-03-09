package data;

import java.sql.*;
import java.util.LinkedList;

import entities.*;

public class DataArticulo {
	
	public Articulo getDisponible(Articulo art, LineaPedido linea) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Articulo a = null;
		DataProveedor dp = new DataProveedor();
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("select * from articulo where id_articulo=? and stock>=?" );
			stmt.setInt(1,art.getId_articulo());
			stmt.setInt(2,linea.getCantidad());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a = new Articulo();
				a.setId_articulo(rs.getInt("id_articulo"));
				a.setNombre(rs.getString("nombre"));
				a.setDescripcion(rs.getString("descripcion"));
				a.setCant_aprox_kg(rs.getInt("cant_aprox_kg"));
				a.setPrecio_sugerido(rs.getFloat("precio_sugerido"));
				
				dp.setProveedor(a);
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
		} return a;
	}
	
	public void actualizarStock(Pedido p) {
		PreparedStatement stmt = null;
		try {
			stmt=DBConnector.getInstancia().getConn()
					.prepareStatement("update articulo set stock=stock-? where id_articulo=?");
			for(LineaPedido l:p.getLineas()) {
				stmt.setInt(1,l.getCantidad());
				stmt.setInt(2,l.getArticulo().getId_articulo());
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
	
	public LinkedList<Articulo> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Articulo> lista = new LinkedList<>();
		try {
			stmt = DBConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from articulo");
			if(rs!=null) {
				while(rs.next()) {
					Articulo art = new Articulo();
					art.setId_articulo(rs.getInt("id_articulo"));
					art.setNombre(rs.getString("nombre"));
					art.setDescripcion(rs.getString("descripcion"));
					art.setCant_aprox_kg(rs.getInt("cant_aprox_kg"));
					art.setPrecio_sugerido(rs.getDouble("precio_sugerido"));
					
					lista.add(art);
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
		} return lista;
	}

}
