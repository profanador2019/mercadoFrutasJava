package data;

import java.sql.*;
import entities.*;

public class DataProveedor {
	
	public void setProveedor(Articulo art) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("select proveedor.* "
							         + "from proveedor inner join articulo " 
							           +"on proveedor.cuil=articulo.cuil_proveedor "
							            +"where id_articulo=?");
			stmt.setInt(1, art.getId_articulo());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Proveedor p = new Proveedor();
				p.setCuil(rs.getInt("cuil"));
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setTel(rs.getInt("tel"));
				art.setProveedor(p);
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
