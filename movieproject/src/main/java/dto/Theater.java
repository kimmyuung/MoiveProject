package dto;

public class Theater {
private int tnum;
private String tname;
private String tseat;
private String tlocation;


@Override
public String toString() {
	return "Theater [tnum=" + tnum + ", tname=" + tname + ", tseat=" + tseat + ", tlocation=" + tlocation + "]";
}

public Theater() {}
public Theater(int tnum, String tname, String tseat, String tlocation) {
	super();
	this.tnum = tnum;
	this.tname = tname;
	this.tseat = tseat;
	this.tlocation = tlocation;
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
public String getTlocation() {
	return tlocation;
}
public void setTlocation(String tlocation) {
	this.tlocation = tlocation;
}

}
