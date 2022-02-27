package data;

import java.sql.*;

import entities.*;

public class DataArticulo {
	
	public Articulo getDisponible(Articulo art) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("select )
		}
	}

}
