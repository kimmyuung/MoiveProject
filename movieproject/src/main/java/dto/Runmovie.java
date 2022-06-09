package dto;

public class Runmovie {

	private String stime;
	private String tname;
	private String mtitle;
	
	public Runmovie() {}

	public Runmovie(String stime, String tname, String mtitle) {
		super();
		this.stime = stime;
		this.tname = tname;
		this.mtitle = mtitle;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	@Override
	public String toString() {
		return "Runmovie [stime=" + stime + ", tname=" + tname + ", mtitle=" + mtitle + "]";
	}

	
	
	
	
	
}
