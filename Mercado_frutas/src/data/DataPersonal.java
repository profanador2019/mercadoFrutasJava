package data;

import entities.*;
import java.sql.*;

public class DataPersonal {
	
	public void setPersonal(Pedido p) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
			          .prepareStatement("select * "
			          		+ "from personal inner join pedido "
			          		+ "on personal.dni=pedido.dni_personal "
			          		+ "where nro_pedido=?");
			
			stmt.setInt(1,p.getNro_pedido());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Personal per= new Personal();
				per.setDni(rs.getInt("dni"));
				per.setApellido(rs.getString("apellido"));
				per.setNombre(rs.getString("nombre"));
				per.setUsuario(rs.getString("usuario"));
				
				p.setVendedor(per);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {rs.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Personal getByUser(Personal p) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Personal per = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("select dni,apellido,nombre,usuario from personal "
							+ "where usuario=? and contraseña=?");
			stmt.setString(1,p.getUsuario());
			stmt.setString(2,p.getContraseña());
			
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				per = new Personal();
				per.setDni(rs.getInt("dni"));
				per.setApellido(rs.getString("apellido"));
				per.setNombre(rs.getString("nombre"));
				per.setUsuario("usuario");
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
		} return per;
	}

}
