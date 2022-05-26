package dto;

public class OrderDetail {
private int orderdetailno;
private int orderdetailacitve;
private int sno;
private int samount;
private int totalprice;
private int orderno;



public OrderDetail() {}


public OrderDetail(int orderdetailno, int orderdetailacitve, int sno, int samount, int totalprice, int orderno) {
	super();
	this.orderdetailno = orderdetailno;
	this.orderdetailacitve = orderdetailacitve;
	this.sno = sno;
	this.samount = samount;
	this.totalprice = totalprice;
	this.orderno = orderno;
}
public int getOrderdetailno() {
	return orderdetailno;
}
public void setOrderdetailno(int orderdetailno) {
	this.orderdetailno = orderdetailno;
}
public int getOrderdetailacitve() {
	return orderdetailacitve;
}
public void setOrderdetailacitve(int orderdetailacitve) {
	this.orderdetailacitve = orderdetailacitve;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getSamount() {
	return samount;
}
public void setSamount(int samount) {
	this.samount = samount;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public int getOrderno() {
	return orderno;
}
public void setOrderno(int orderno) {
	this.orderno = orderno;
}


@Override
public String toString() {
	return "OrderDetail [orderdetailno=" + orderdetailno + ", orderdetailacitve=" + orderdetailacitve + ", sno=" + sno
			+ ", samount=" + samount + ", totalprice=" + totalprice + ", orderno=" + orderno + "]";
}


}
