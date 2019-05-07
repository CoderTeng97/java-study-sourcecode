package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionDB {
	private static String URL = "jdbc:mysql://127.0.0.1:3360/offer?useUnicode=true&characterEncoding=utf-8";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String PASSWORD = "root";
	private static String NAME = "123456";
	
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public void con(){
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,NAME,PASSWORD);
			ps =  con.prepareStatement("");
			ps.getResultSet();
			while(rs.next()){
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
