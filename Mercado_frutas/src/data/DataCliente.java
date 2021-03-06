package data;

import java.util.LinkedList;
import entities.*;
import java.sql.*;

public class DataCliente {
	
	public LinkedList<Cliente> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Cliente> clientes = null;
		try {
			stmt = DBConnector.getInstancia().getConn().createStatement();
			rs=stmt.executeQuery("select * from cliente");
			if(rs!=null) {
			    clientes = new LinkedList<Cliente>();
				while(rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt("id_cliente"));
				cli.setDni(rs.getInt("dni"));
				cli.setApellido(rs.getString("apellido"));
				cli.setNombre(rs.getString("nombre"));
				cli.setEmail(rs.getString("email"));
				cli.setDireccion(rs.getString("direccion"));
				cli.setTel(rs.getInt("tel"));
				
				clientes.add(cli);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null){rs.close();}
			     if(stmt!=null){stmt.close();}
			     DBConnector.getInstancia().releaseConn();}
			     catch(SQLException e) {
			    	 e.printStackTrace();
			     }
			
		} return clientes;
	}
	
	public LinkedList<Cliente> getByApellido(Cliente cli){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<Cliente> clientes = new LinkedList<>();
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("select * from cliente where apellido=?");
			stmt.setString(1, cli.getApellido());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Cliente c = new Cliente();
					c.setId(rs.getInt("id_cliente"));
					c.setApellido(rs.getString("apellido"));
					c.setNombre(rs.getString("nombre"));
					c.setDni(rs.getInt("dni"));
					c.setEmail(rs.getString("email"));
					c.setDireccion(rs.getString("direccion"));
					c.setTel(rs.getInt("tel"));
					
					clientes.add(c);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {stmt.close();}
				if(rs!=null) {rs.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} return clientes;
	}
	
	public void addCliente(Cliente cli) {
		PreparedStatement stmt = null;
		ResultSet krs = null;
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("insert into cliente(dni,apellido,nombre,email,direccion,tel) values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cli.getDni());
			stmt.setString(2, cli.getApellido());
			stmt.setString(3, cli.getNombre());
			stmt.setString(4, cli.getEmail());
			stmt.setString(5, cli.getDireccion());
			stmt.setInt(6, cli.getTel());
			
			stmt.executeUpdate();
			
			krs = stmt.getGeneratedKeys();
			if(krs!=null && krs.next()) {
				cli.setId(krs.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(krs!=null) {krs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteCliente(Cliente cli) {
		PreparedStatement stmt = null;
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("delete from cliente where id_cliente=?");
			stmt.setInt(1, cli.getId());
			stmt.executeUpdate();
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
	
	public void editCliente(Cliente cli) {
		PreparedStatement stmt = null;
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("update cliente set dni=?, apellido=?, nombre=?, email=?, direccion=?, tel=? where id_cliente=?");
			// Para simplificar, el id de un cliente no puede modificarse.
			stmt.setInt(1,cli.getDni());
			stmt.setString(2,cli.getApellido());
			stmt.setString(3,cli.getNombre());
			stmt.setString(4,cli.getEmail());
			stmt.setString(5,cli.getDireccion());
			stmt.setInt(6,cli.getTel());
			stmt.setInt(7,cli.getId());
			
			stmt.executeUpdate();
			
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
	
	public Cliente getById(Cliente c) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			stmt = DBConnector.getInstancia().getConn().prepareStatement("select * from cliente where id_cliente=?");
			stmt.setInt(1, c.getId());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDni(rs.getInt("dni"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setTel(rs.getInt("tel"));
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
		} return cliente;
	}
	
	public void setCliente(Pedido p) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBConnector.getInstancia().getConn()
					.prepareStatement("select * "
							+ "from cliente natural join pedido "
							+ "where nro_pedido=?");
			
			stmt.setInt(1,p.getNro_pedido());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id_cliente"));
				c.setDni(rs.getInt("dni"));
				c.setApellido(rs.getString("apellido"));
				c.setNombre(rs.getString("nombre"));
				c.setEmail(rs.getString("email"));
				c.setDireccion(rs.getString("direccion"));
				c.setTel(rs.getInt("tel"));
				
				p.setCliente(c);
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
