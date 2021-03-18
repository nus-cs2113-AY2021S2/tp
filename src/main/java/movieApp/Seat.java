package movieApp;

import java.io.Serializable;

public class Seat implements Serializable{
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

}