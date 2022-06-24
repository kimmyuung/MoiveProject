package dto;

public class Ticket {

	
	private int tnum; // 티켓 번호
	private int tno; // 상영관 번호
	private int rno; // 상영영화 번호
	private String date; // 날짜
	private String seat; // 좌석
	private String mid; // 예약한 아이디
	
	public Ticket(int tnum, int tno, int rno, String date, String seat, String mid) {
		super();
		this.tnum = tnum;
		this.tno = tno;
		this.rno = rno;
		this.date = date;
		this.seat = seat;
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Ticket [tnum=" + tnum + ", tno=" + tno + ", rno=" + rno + ", date=" + date + ", seat=" + seat + ", mid="
				+ mid + "]";
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
			
	
}
