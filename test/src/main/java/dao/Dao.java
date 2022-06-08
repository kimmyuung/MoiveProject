package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	protected Connection con;	
	protected ResultSet rs;
	protected PreparedStatement ps;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
					"root","1234");
		}catch (Exception e) { System.out.println("연동 실패 "+e);}
	}
}