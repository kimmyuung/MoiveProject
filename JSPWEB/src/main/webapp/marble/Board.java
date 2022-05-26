package dto;

public class Board {
	int bno;
	String cname;
	int buyprice;
	int payprice;
	int pno; // 땅 주인
	public Board() {
	}
	public Board(int bno, String cname, int buyprice, int payprice, int pno) {
		super();
		this.bno = bno;
		this.cname = cname;
		this.buyprice = buyprice;
		this.payprice = payprice;
		this.pno = pno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getBuyprice() {
		return buyprice;
	}
	public void setBuyprice(int buyprice) {
		this.buyprice = buyprice;
	}
	public int getPayprice() {
		return payprice;
	}
	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
}
