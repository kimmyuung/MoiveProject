package dto;

public class Runmovie {

	private String rtitle;
	private String rtime;
	
	public Runmovie() {}
	public Runmovie(String rtitle, String rtime) {
		super();
		this.rtitle = rtitle;
		this.rtime = rtime;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
	
}
