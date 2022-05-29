package dto;

public class Order {
private int orderno;
private String orderdate;
private String ordername;
private String orderphone;
private String orderaddress;
private String ordereqeust;
private int ordertotalpay;
private int mno;

public Order() {}

public Order(int orderno, String orderdate, String ordername, String orderphone, String orderaddress,
		String ordereqeust, int ordertotalpay, int mno) {
	super();
	this.orderno = orderno;
	this.orderdate = orderdate;
	this.ordername = ordername;
	this.orderphone = orderphone;
	this.orderaddress = orderaddress;
	this.ordereqeust = ordereqeust;
	this.ordertotalpay = ordertotalpay;
	this.mno = mno;
}





public int getOrderno() {
	return orderno;
}

public void setOrderno(int orderno) {
	this.orderno = orderno;
}

public String getOrderdate() {
	return orderdate;
}

public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}

public String getOrdername() {
	return ordername;
}

public void setOrdername(String ordername) {
	this.ordername = ordername;
}

public String getOrderphone() {
	return orderphone;
}

public void setOrderphone(String orderphone) {
	this.orderphone = orderphone;
}

public String getOrderaddress() {
	return orderaddress;
}

public void setOrderaddress(String orderaddress) {
	this.orderaddress = orderaddress;
}

public String getOrdereqeust() {
	return ordereqeust;
}

public void setOrdereqeust(String ordereqeust) {
	this.ordereqeust = ordereqeust;
}

public int getOrdertotalpay() {
	return ordertotalpay;
}

public void setOrdertotalpay(int ordertotalpay) {
	this.ordertotalpay = ordertotalpay;
}

public int getMno() {
	return mno;
}

public void setMno(int mno) {
	this.mno = mno;
}

@Override
public String toString() {
	return "Order [orderno=" + orderno + ", orderdate=" + orderdate + ", ordername=" + ordername + ", orderphone="
			+ orderphone + ", orderaddress=" + orderaddress + ", ordereqeust=" + ordereqeust + ", ordertotalpay="
			+ ordertotalpay + ", mno=" + mno + "]";
}





}
