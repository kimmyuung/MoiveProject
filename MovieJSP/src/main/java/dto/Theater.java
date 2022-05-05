package dto;

public class Theater {
private int tnum;
private String tname;
private String tseat;

public Theater() {}
public Theater(int tnum, String tname, String tseat) {
	super();
	this.tnum = tnum;
	this.tname = tname;
	this.tseat = tseat;
}

public int getTnum() {
	return tnum;
}
public void setTnum(int tnum) {
	this.tnum = tnum;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTseat() {
	return tseat;
}
public void setTseat(String tseat) {
	this.tseat = tseat;
}

}
