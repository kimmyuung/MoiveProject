package dto;

public class Movie {
private int mno;
private String mtitle;
private String mcategory;
private String mruntime;

public Movie() {}
public Movie(int mno, String mtitle, String mcategory, String mruntime) {
	super();
	this.mno = mno;
	this.mtitle = mtitle;
	this.mcategory = mcategory;
	this.mruntime = mruntime;
}
public int getMno() {
	return mno;
}
public void setMno(int mno) {
	this.mno = mno;
}
public String getMtitle() {
	return mtitle;
}
public void setMtitle(String mtitle) {
	this.mtitle = mtitle;
}
public String getMcategory() {
	return mcategory;
}
public void setMcategory(String mcategory) {
	this.mcategory = mcategory;
}
public String getMruntime() {
	return mruntime;
}
public void setMruntime(String mruntime) {
	this.mruntime = mruntime;
}
@Override
public String toString() {
	return "Movie [mnum=" + mno + ", mtitle=" + mtitle + ", mcategory=" + mcategory + ", mruntime=" + mruntime + "]";
}




}
