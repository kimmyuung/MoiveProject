package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Board {
	
	private int bno;
	private String btitle;
	private String context;
	private String password;
	private String writer;
	private String write_time;
	
	public Board() {}
	public Board(int bno, String btitle, String context, String password, String writer, String write_time) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.context = context;
		this.password = password;
		this.writer = writer;
		if( write_time != null ) { 
			
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = write_time.split(" ")[0];	// 날짜만 
			String boardtime = write_time.split(" ")[1]; // 시간만 
								// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) { this.write_time = boardtime;}
			// 동일하지 않으면 
			else { this.write_time = boardday; }
			
		}else { this.write_time = write_time; }
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", context=" + context + ", password=" + password
				+ ", writer=" + writer + ", write_time=" + write_time + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
	
	
}
