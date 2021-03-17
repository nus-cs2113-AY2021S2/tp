package movieApp;

import java.io.Serializable;
import java.util.*;


public class Movie {
	private String movieTitle;
	private int movieID;
	private Calendar startDate; 
	private Calendar endDate;
	private String director;
	private String[] cast;
	private String genre;
	private String synopsis;
	private ArrayList<Review> reviews;
	private movieStatus showingStatus;

	public enum movieStatus{
		COMINGSOON, PREORDER, NOWSHOWING, ENDSHOWING
	}
	
	public Movie(String movieTitle, int movieID, int startY, int startM, int startD, int endY, int endM, int endD,
				 String director, String[] cast, String genre, String synopsis, int choice, ArrayList<Review> reviews) {
		this.movieTitle = movieTitle;
		this.movieID = movieID;
		this.startDate = Calendar.getInstance();
		this.startDate.set(startY, startM-1, startD,0,0,0);
		//set(year, month, date, hour, minute, second)
		this.endDate = Calendar.getInstance();
		this.endDate.set(endY, endM-1, endD,0,0,0);
		this.director = director; 
		this.cast = cast;
		this.genre = genre; 
		this.synopsis = synopsis;
		setMovieStatus(choice);
		this.reviews = reviews;
	}

	
	public String getMovieTitle() {
		return movieTitle; 
	}
	
	public int getMovieID() {
		return movieID;
	}
	
	public float getOverallRating() {
		if(reviews.size()==0) {
			return -1;
		}
		else {
			return calculateOverallRating(); 
		}
	}
	
	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public String getDirector() {
		return director; 
	}

	public void printCast() {
		int i = 0;
		while (i<cast.length) {
			System.out.println(cast[i]);
			i++;
		}
	}
	
	public String getGenre() {
		return genre; 
	}
	
	public String getSynopsis() {
		return synopsis; 
	}

	public void printReviews() {
		int i = 0;
		while (i<reviews.size()) {
			System.out.println("---------------------------------------------------");
			System.out.println("Review No. " + (i+1) + ":");
			System.out.println("Rating: "+ reviews.get(i).getRating());
			System.out.println("Rating content: " + reviews.get(i).getComment());
			i++;
		}
	}
	
	public String getShowingStatus() {
		return showingStatus.name(); 
	}
	
	public void setMovieStatus(int choice) {
		switch(choice){
		case 1: this.showingStatus =  movieStatus.COMINGSOON; break;
		case 2: this.showingStatus = movieStatus.PREORDER; break;
		case 3: this.showingStatus = movieStatus.NOWSHOWING; break;
		case 4: this.showingStatus = movieStatus.ENDSHOWING; break;
		default: break; 
		}
	}
	
	public void addReview(String comment, int rating) {		
		Review r = new Review(comment, rating);
		reviews.add(r);

	}
	
	private float calculateOverallRating() {
		int i; 
		float total = 0; 
		for(i=0;i<reviews.size();i++) {
			total = total + reviews.get(i).getRating();
		}
		return total/(reviews.size());
	}

	
	public void displayMovie() {
		System.out.println("====================================================================");
		System.out.println("Movie Title: " + getMovieTitle());
		System.out.println("Overall Rating: " + getOverallRating());
		System.out.println("Start Date: " + getStartDate().getTime());
		System.out.println("End Date: " + getEndDate().getTime());
		System.out.println("Showing Status: " + getShowingStatus());
		System.out.println("====================================================================");
		System.out.println("Genre: " + getGenre());
		System.out.println("Director: " + getDirector());
		
		System.out.println("Cast: ");
		printCast();
		System.out.println();
		System.out.println("Synopsis: " + getSynopsis());
		
		System.out.println("======================================Reviews======================================");
		printReviews(); 
	}

}