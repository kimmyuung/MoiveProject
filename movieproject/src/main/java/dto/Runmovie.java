package dto;

public class Runmovie {

	private String stime;
	private int tno;
	private int mno;
	
	public Runmovie() {}

	public Runmovie(String stime, int tno, int mno) {
		super();
		this.stime = stime;
		this.tno = tno;
		this.mno = mno;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Runmovie [stime=" + stime + ", tno=" + tno + ", mno=" + mno + "]";
	}
	
	
	
	
}
