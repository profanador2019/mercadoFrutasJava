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

}
