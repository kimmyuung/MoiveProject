package dto;

public class Runmovie {

	private String stime;
	private int tno;
	private String mtitle;
	
	public Runmovie() {}

	public Runmovie(String stime, int tno, String mtitle) {
		super();
		this.stime = stime;
		this.tno = tno;
		this.mtitle = mtitle;
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

	@Override
	public String toString() {
		return "Runmovie [stime=" + stime + ", tno=" + tno + ", mtitle=" + mtitle + "]";
	}

	
	
	
	
	
}
