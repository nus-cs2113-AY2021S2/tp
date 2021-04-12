package movieApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public class Movie implements Serializable {
    private static final long serialVersionUID = -7893868657490723698L;
    private String movieTitle;
    private final int movieID;
    private Calendar startDate;
    private Calendar endDate;
    private String director;
    private String[] cast;
    private final String genre;
    private String synopsis;
    private final ArrayList<Review> reviews;
    private movieStatus showingStatus;

    /**
     * Class constructor.
     */
    public Movie(String movieTitle, int movieID, int startY, int startM, int startD, int endY, int endM, int endD,
                 String director, String[] cast, String genre, String synopsis, int choice, ArrayList<Review> reviews) {
        this.movieTitle = movieTitle;
        this.movieID = movieID;
        this.startDate = Calendar.getInstance();
        this.startDate.set(startY, startM - 1, startD, 0, 0, 0);
        this.endDate = Calendar.getInstance();
        this.endDate.set(endY, endM - 1, endD, 0, 0, 0);
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.synopsis = synopsis;
        setMovieStatus(choice);
        this.reviews = reviews;
    }

    /**
     * Returns a String, which is the name of the specified Movie object, for display purposes
     *
     * @return a String, containing the name of the movie
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Setter for the movie title variable
     *
     * @param movieTitle the name of the movie that the specified Movie object is to take on
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * Returns an int, which is the id of the specified Movie object, for display purposes and operations
     *
     * @return an int, containing the ID the movie
     */
    public int getMovieID() {
        return movieID;
    }

    /**
     * Returns an int, which is the number of reviews the specified Movie object possesses, for display purposes
     *
     * @return an int, containing the number of reviews the movie has
     */
    public int getReviewSize() {
        return reviews.size();
    }

    /**
     * Returns a String, which is the average value of reviews the specified Movie object possesses,
     * for display purposes
     *
     * @return a String, containing the average rating value of the movie.
     * Displays an error message if there are no revies
     */
    public String getOverallRating() {
        if (reviews.size() == 0) {
            return "No ratings yet. You can start by adding one!";
        } else {
            return Float.toString(calculateOverallRating()).substring(0, 3);
        }
    }

    /**
     * Returns a Calendar object, which contains date and time information of the start date of the movie,
     * for display purposes
     *
     * @return a Calendar object, containing the date and time information of the start date of the movie
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Allows the start date of the Movie object to be changed, according to the input
     *
     * @param startDate a Calendar object, containing the date and time information of the start date of the movie
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns a Calendar object, which contains date and time information of the end date of the movie,
     * for display purposes
     *
     * @return a Calendar object, containing the date and time information of the end date of the movie
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Allows the end date of the Movie object to be changed, according to the input
     *
     * @param endDate a Calendar object, containing the date and time information of the start date of the movie
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * Allows the cast list of the Movie object to be changed, according to the input
     *
     * @param cast a String array, containing the names of the cast members who acted in the movie
     */
    public void setCast(String[] cast) {
        this.cast = cast;
    }

    /**
     * Returns a String containing the name of the director of the movie, for display purposes
     *
     * @return director  a String array, containing the name of the movie director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Allows the director of the Movie object to be changed, according to the input
     *
     * @param director a String, containing the name of the movie director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Displays the cast members who acted in the movie, one name per line.
     */
    public void printCast() {
        int i = 0;
        while (i < cast.length) {
            System.out.println(cast[i]);
            i++;
        }
    }

    /**
     * Returns a String containing the name of the genre of the movie, for display purposes
     *
     * @return genre a String , containing the genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Displays all the reviews attached to the Movie, by retrieving the values stored in the Review objects
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Allows the synopsis of the Movie object to be changed, according to the input
     *
     * @param synopsis a String, containing the movie synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Displays all the reviews attached to the Movie, by retrieving the values stored in the Review objects
     */
    public void printReviews() {
        int i = 0;
        while (i < reviews.size()) {
            System.out.println("---------------------------------------------------");
            System.out.println("Review No. " + (i + 1) + ":");
            System.out.println("Rating: " + reviews.get(i).getRating());
            System.out.println("Rating content: " + reviews.get(i).getComment());
            i++;
        }
    }

    /**
     * Returns a String containing the showing status of the movie, for display purposes
     *
     * @return showingStatus a String , containing the  showing status of the movie
     */
    public String getShowingStatus() {
        return showingStatus.name();
    }

    /**
     * Allows the movie status of an object to be changed, according to the input.
     *
     * @param choice a value which corresponds to an enumeration, to select the showing status of a movie.
     */
    public void setMovieStatus(int choice) {
        switch (choice) {
            case 1:
                this.showingStatus = movieStatus.COMINGSOON;
                break;
            case 2:
                this.showingStatus = movieStatus.PREORDER;
                break;
            case 3:
                this.showingStatus = movieStatus.NOWSHOWING;
                break;
            case 4:
                this.showingStatus = movieStatus.ENDSHOWING;
                break;
            default:
                break;
        }
    }

    /**
     * Creates a new Review object and attach it to the specified Movie object.
     *
     * @param comment a String which contains the comment of the review to be made,
     * @param rating  an int which contains the rating value given.
     */
    public void addReview(String comment, int rating) {
        Review r = new Review(comment, rating);
        reviews.add(r);
    }

    /**
     * Provides the overall rating of a movie, given by taking the average of all the Reviews
     *
     * @return overallRating  a float which contains the average value of all Reviews of a movie
     */
    public float calculateOverallRating() {
        int i;
        float total = 0;
        for (i = 0; i < reviews.size(); i++) {
            total = total + reviews.get(i).getRating();
        }
        return total / (reviews.size());
    }

    /**
     * Utilises the getter functions, to display all relevant details of the movie.
     */
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

    public enum movieStatus {
        COMINGSOON, PREORDER, NOWSHOWING, ENDSHOWING
    }

}