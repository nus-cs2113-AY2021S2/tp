package movieApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {
    private static final long serialVersionUID = 7128894551549758309L;
    protected ArrayList<Cinema> cinemaList;
    private final int cineplexID;
    private final String cineplexName;
    private final ArrayList<Integer> movieList;

    public Cineplex(int ID, String name, ArrayList<Integer> movieList) {
        this.cineplexID = ID;
        this.cineplexName = name;
        this.movieList = movieList;
        this.cinemaList = new ArrayList<>();
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