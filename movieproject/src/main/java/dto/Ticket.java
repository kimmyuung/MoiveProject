package dto;

public class Ticket {
private int tnum; // 티켓번호
private String ttile; // 영화 제목
private String starttime;
private String ttname;// 영화관 이름
private int tprice;
private String tseat;
private int mno; // 구매한 회원 


public Ticket() {}

public Ticket(int tnum, String ttile, String starttime, String ttname, int tpeople, int tprice, String tseat, int mno) {
	super();
	this.tnum = tnum;
	this.ttile = ttile;
	this.starttime = starttime;
	this.ttname = ttname;
	this.tprice = tprice;
	this.tseat = tseat;
	this.mno = mno;
}


@Override
public String toString() {
	return "Ticket [tnum=" + tnum + ", ttile=" + ttile + ", starttime=" + starttime + ", ttname=" + ttname + ", tprice="
			+ tprice + ", tseat=" + tseat + ", mno=" + mno + "]";
}


public int getTnum() {
	return tnum;
}
public void setTnum(int tnum) {
	this.tnum = tnum;
}
public String getTtile() {
	return ttile;
}
public void setTtile(String ttile) {
	this.ttile = ttile;
}
public String getStarttime() {
	return starttime;
}
public void setStarttime(String starttime) {
	this.starttime = starttime;
}
public String getTtname() {
	return ttname;
}
public void setTtname(String ttname) {
	this.ttname = ttname;
}
public int getTprice() {
	return tprice;
}
public void setTprice(int tprice) {
	this.tprice = tprice;
}
public String getTseat() {
	return tseat;
}
public void setTseat(String tseat) {
	this.tseat = tseat;
}

public int getMno() {
	return mno;
}

public void setMno(int mno) {
	this.mno = mno;
}

}
