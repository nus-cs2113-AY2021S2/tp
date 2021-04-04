package movieApp;

import java.io.Serializable;

public class Seat implements Serializable{
	private static final long serialVersionUID = -6172861579975166925L;
	private int row;
	private int number;
	private boolean status;

	
	public Seat(int row, int number, boolean taken) {
		this.row = row;
		this.number = number;
		this.status = taken;
	}
	
	public void setStatus(boolean taken){
		this.status = taken;
	}
	
	public boolean getStatus() {
		return this.status;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn(){
		return this.number;
	}
}