package movieApp;

import java.io.Serializable;

import java.util.ArrayList; // import the ArrayList class

public class Cineplex implements Serializable{
	private static final long serialVersionUID = 7128894551549758309L;
	private int cineplexID;
	private String cineplexName;
	private ArrayList<Integer> movieList;
	protected ArrayList<Cinema> cinemaList;
	
	public Cineplex(int ID, String name, ArrayList<Integer> movieList) {
		this.cineplexID = ID;
		this.cineplexName = name;
		this.movieList = movieList;
		this.cinemaList = new ArrayList<Cinema>();
	}
	
	//Cineplex
	public int getCineplexID() {
		return cineplexID;
	}
	public String getCineplexName() {
		return cineplexName;
	}
	
	//Movie List
	public ArrayList<Integer> getMovieList() {
		return movieList;
	}
	
	//Cinema List
	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}
	
}