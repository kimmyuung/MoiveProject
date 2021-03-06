package dto;

public class Runmovie {

	private String stime;
	private int tno;
	private String mtitle;
	private int rno;
	public Runmovie() {}

	public Runmovie(int tno, String mtitle, String stime, int rno) {
		super();
	
		this.tno = tno;
		this.mtitle = mtitle;
		this.stime = stime;
		this.rno = rno;
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

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "Runmovie [stime=" + stime + ", tno=" + tno + ", mtitle=" + mtitle + ", rno=" + rno + "]";
	}

	
	

	
	
	
	
	
}
