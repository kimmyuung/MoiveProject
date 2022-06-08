package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	protected Connection con; // db연결 클래스
	protected PreparedStatement ps; // db조작 인터페이스
	protected ResultSet rs;
	
	public Dao() {

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://database-1.cc0om84n0yfa.ap-northeast-2.rds.amazonaws.com:3306/movieproject?serverTimezone=UTC",
				"admin","ghaud1003!");
		}catch(Exception e) {System.out.println("Database connection error!" + e);}
	}
	
}
