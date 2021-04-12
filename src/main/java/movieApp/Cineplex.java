package movieApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {
    private static final long serialVersionUID = 7128894551549758309L;
    private final int cineplexID;
    private final String cineplexName;
    private final ArrayList<Integer> movieList;
    protected ArrayList<Cinema> cinemaList;

    /**
     * Class constructor.
     */
    public Cineplex(int ID, String name, ArrayList<Integer> movieList) {
        this.cineplexID = ID;
        this.cineplexName = name;
        this.movieList = movieList;
        this.cinemaList = new ArrayList<>();
    }

    /**
     * Returns an int, which is the id of the Cineplex object
     * that can then be used in operations.
     *
     * @return the id of the specified Cineplex object
     */
    public int getCineplexID() {
        return cineplexID;
    }

    /**
     * Returns a String, which is the name of the Cineplex, for display purposes.
     *
     * @return the name of the specified Cineplex object
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Returns an ArrayList of movie IDs, contained in the Cineplex object
     *
     * @return an ArrayList of movie IDs, contained in the Cineplex object
     */
    public ArrayList<Integer> getMovieList() {
        return movieList;
    }

    /**
     * Returns an ArrayList of Cinema objects, contained in the Cineplex object
     *
     * @return an ArrayList of movie IDs, contained in the Cineplex object
     */
    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

}