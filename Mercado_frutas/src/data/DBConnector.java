package data;

import java.sql.*;

public class DBConnector {
	
	private static DBConnector instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="mf";
	private String pass="himitsu";
	private String db="mercado_frutas";
	private int conectados=0;
	private Connection conn=null;
	
	private DBConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}}
	
	public static DBConnector getInstancia() {
		if(instancia==null) {
			instancia=new DBConnector();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if(conectados<=0) {
			conn.close();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}
