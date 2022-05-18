package dto;

public class Movie {
private int mno;
private String mtitle;
private String mruntime;
private String mimg;
private int mcategory;
private int mprice;

public Movie() {}
public Movie(int mno, String mtitle, int mprice, int mcategory, String mruntime, String mimg ) {
	super();
	this.mno = mno;
	this.mtitle = mtitle;
	this.mprice = mprice;
	this.mcategory = mcategory;
	this.mruntime = mruntime;
	this.mimg = mimg;
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
public int getMcategory() {
	return mcategory;
}
public void setMcategory(int mcategory) {
	this.mcategory = mcategory;
}
public String getMruntime() {
	return mruntime;
}
public void setMruntime(String mruntime) {
	this.mruntime = mruntime;
}

public String getMimg() {
	return mimg;
}
public void setMimg(String mimg) {
	this.mimg = mimg;
}

public int getMprice() {
	return mprice;
}
public void setMprice(int mprice) {
	this.mprice = mprice;
}



@Override
public String toString() {
	return "Movie [mno=" + mno + ", mtitle=" + mtitle + ", mruntime=" + mruntime + ", mimg=" + mimg + ", mcategory="
			+ mcategory + ", mprice=" + mprice + "]";
}





}
