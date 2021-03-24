package movieApp.movie;


import java.io.Serializable;

public class Review implements  Serializable{
	private static final long serialVersionUID = -7155346385146047745L;
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
