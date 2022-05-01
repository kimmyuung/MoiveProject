package dto;

public class Member {
private int mnum;
private String mid;
private String mpw;
private String mname;
private String mphone;
private String maddress;
private String memail;
public Member() {}
public Member(int mnum, String mid, String mpw, String mname, String mphone, String maddress, String memail) {
	super();
	this.mnum = mnum;
	this.mid = mid;
	this.mpw = mpw;
	this.mname = mname;
	this.mphone = mphone;
	this.maddress = maddress;
	this.memail = memail;
}
public int getMnum() {
	return mnum;
}
public void setMnum(int mnum) {
	this.mnum = mnum;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getMpw() {
	return mpw;
}
public void setMpw(String mpw) {
	this.mpw = mpw;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMphone() {
	return mphone;
}
public void setMphone(String mphone) {
	this.mphone = mphone;
}
public String getMaddress() {
	return maddress;
}
public void setMaddress(String maddress) {
	this.maddress = maddress;
}
public String getMemail() {
	return memail;
}
public void setMemail(String memail) {
	this.memail = memail;
}


}
