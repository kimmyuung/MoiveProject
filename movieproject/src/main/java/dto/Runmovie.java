package dto;

public class Runmovie {

	private String stime;
	private String etime;
	private String sdate;
	private String edate;
	private int tno;
	private int mno;
	public Runmovie() {}
	
	public Runmovie(String stime, String etime, String sdate, String edate, int tno, int mno) {
		super();
		
		this.stime = stime;
		this.etime = etime;
		this.sdate = sdate;
		this.edate = edate;
		this.tno = tno;
		this.mno = mno;
	}

	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
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
		return "Runmovie stime=" + stime + ", etime=" + etime + ", sdate=" + sdate + ", edate="
				+ edate + ", tno=" + tno + ", mno=" + mno + "]";
	}

	
	
}
