package dto;

public class Cart {

	private int cartno;
	private int sno;
	private int total_price;
	private int total_amount;
	private int pno;
	private int mno;
	
	
	public Cart() {}
	
	public Cart(int cartno, int sno, int total_price, int total_amount, int pno, int mno) {
		super();
		this.cartno = cartno;
		this.sno = sno;
		this.total_price = total_price;
		this.total_amount = total_amount;
		this.pno = pno;
		this.mno = mno;
	}
	
	
	
	public Cart(int cartno, int sno, int total_price, int pno, int mno) {
		super();
		this.cartno = cartno;
		this.sno = sno;
		this.total_price = total_price;
		this.pno = pno;
		this.mno = mno;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", sno=" + sno + ", total_price=" + total_price + ", total_amount="
				+ total_amount + ", pno=" + pno + ", mno=" + mno + "]";
	}

	
	
}
