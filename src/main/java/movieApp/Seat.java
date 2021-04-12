package movieApp;

import java.io.Serializable;

public class Seat implements Serializable{
	private static final long serialVersionUID = -6172861579975166925L;
	private int row;
	private int number;
	private boolean status;

	/**
	 * Class constructor.
	 */
	public Seat(int row, int number, boolean taken) {
		this.row = row;
		this.number = number;
		this.status = taken;
	}

	/**
	 * Sets a seat as available/ unavailable according to input argument
	 * @param  taken  a boolean value, that will indicate the availability of the Seat object
	 */
	public void setStatus(boolean taken){
		this.status = taken;
	}

	/**
	 * Returns the availability status of the Seat object
	 * @return   returns a boolean value, corresponding to the availability of the Seat object
	 */
	public boolean getStatus() {
		return this.status;
	}

	/**
	 * Returns the positional information, row number, of the Seat object
	 * @return   returns an int, which is the row number of the Seat object
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Returns the positional information, column number, of the Seat object
	 * @return   returns an int, which is the column number of the Seat object
	 */
	public int getColumn(){
		return this.number;
	}
}