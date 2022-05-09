package dto;

public class Ticket {
private int tnum;
private String ttile; // 영화 제목
private String starttime;
private String ttname;// 영화관 이름
private int tpeople;
private int tprice;
private String tseat;
public int getTnum() {
	return tnum;
}

public Ticket() {}

public Ticket(int tnum, String ttile, String starttime, String ttname, int tpeople, int tprice, String tseat) {
	super();
	this.tnum = tnum;
	this.ttile = ttile;
	this.starttime = starttime;
	this.ttname = ttname;
	this.tpeople = tpeople;
	this.tprice = tprice;
	this.tseat = tseat;
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
public int getTpeople() {
	return tpeople;
}
public void setTpeople(int tpeople) {
	this.tpeople = tpeople;
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

}
