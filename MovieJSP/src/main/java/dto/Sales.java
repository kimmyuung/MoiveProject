package dto;

public class Sales {
private int sale;
private String sdate;


public Sales() {}

public Sales(int sale, String sdate) {
	super();
	this.sale = sale;
	this.sdate = sdate;
}
public int getSale() {
	return sale;
}
public void setSale(int sale) {
	this.sale = sale;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}


}
