package movieApp;


import java.io.Serializable;

public class Review implements  Serializable{
	private String comment;
	private int rating;
	
	public Review(String c, int r) {
		comment = c;
		rating = r; 
	}
	
	public String getComment() {
		return comment;
	}
	
	public int getRating(){
		return rating; 
	}

}
