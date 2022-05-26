package dto;

public class Player {
	int pno;
	int location;
	int money;
	int turn;
	String name;
	String img;
	public Player() {
	}
	public Player(int pno, int location, int money, int turn, String name, String img) {
		super();
		this.pno = pno;
		this.location = location;
		this.money = money;
		this.turn = turn;
		this.name = name;
		this.img = img;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
