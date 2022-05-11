package dao;

import java.util.ArrayList;

import dto.Theater;

public class TheaterDao extends Dao{
	
	public TheaterDao() {
		super();
	}
	public static TheaterDao theaterdao = new TheaterDao();
	// dao 호출시 반복되는 new 연산자 
	public static TheaterDao getTheaterDao() {return theaterdao;}

	
	public boolean theateradd() {return false;}
	
	public ArrayList<Theater> theaterlist() {return null;}
	
	public boolean theaterdelete() {return false;}
	
	public boolean theaterupdate() {return false;}
}
