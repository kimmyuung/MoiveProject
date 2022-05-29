package dto;

public class Product {
private int pno;
private String pname;
private int pprice;
private String pimg;


public Product() {}

public Product(int pno, String pname, int pprice, String pimg) {
	super();
	this.pno = pno;
	this.pname = pname;
	this.pprice = pprice;
	this.pimg = pimg;
}
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPprice() {
	return pprice;
}
public void setPprice(int pprice) {
	this.pprice = pprice;
}
public String getPimg() {
	return pimg;
}
public void setPimg(String pimg) {
	this.pimg = pimg;
}

@Override
public String toString() {
	return "Product [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pimg=" + pimg + "]";
}




}
