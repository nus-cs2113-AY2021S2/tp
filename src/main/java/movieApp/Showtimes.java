package movieApp;

import java.io.Serializable;
import java.util.Calendar;

public class Showtimes implements Serializable {
    private static final long serialVersionUID = -6009080018075884803L;
    private final int showtimeID;
    private final Calendar dateTime;
    private final int cinemaID;
    private final int cineplexID;
    private final int movieID;
    private final String movieTitle;
    private final Seat[][] seatPlan; //true means taken, false means empty
    protected Movie mv;

    /**
     * Class constructor.
     */
    public Showtimes(int id, Calendar date, Cinema cinema, Movie movie) {
        int r = cinema.getR();
        int c = cinema.getC();
        this.seatPlan = new Seat[r][c];

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                seatPlan[row][col] = new Seat(row, col, false);
            }
        }

        this.showtimeID = id;
        this.dateTime = date;
        this.movieID = movie.getMovieID();
        this.movieTitle = movie.getMovieTitle();
        this.cinemaID = cinema.getCinemaID();
        this.cineplexID = cinema.getCineplexID();
        this.mv = movie;

    }

    /**
     * Displays necessary information about the Showtimes object.
     */
    public void showInfo() {
        System.out.println("Showtime ID " + showtimeID + ", Movie title: " + movieTitle + ", Datetime: " + dateTime.get(Calendar.YEAR) + " " + (dateTime.get(Calendar.MONTH) + 1) + " " + dateTime.get(Calendar.DATE) + " " + dateTime.get(Calendar.HOUR_OF_DAY) + " " + dateTime.get(Calendar.MINUTE));
    }

    /**
     * Returns an int, which is the id of the Showtimes object
     * that can then be used in operations.
     *
     * @return the id of the specified Showtimes object
     */
    public int getShowtimeID() {
        return showtimeID;
    }

    /**
     * Returns an int, which is the id of the movie attached to this
     * Showtimes object, that can then be used in operations regarding Movie objects.
     *
     * @return the id of the movie attached to the specified Showtimes object
     */
    public int getMovieID() {
        return movieID;
    }

    /**
     * Returns a Movie object, which an instance of Movie class, which can be directly
     * used in operations, or for using the necessary methods
     *
     * @return the Movie object, corresponding to the object attached to the specified Showtimes object
     */
    public Movie getMovie() {
        return mv;
    }

    /**
     * Returns a String, containing the name of the movie
     *
     * @return the name of the movie attached to the specified Showtimes object
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Returns a Calendar object, containing date and time information about the movie screenign.
     *
     * @return the date and time of the movie attached to the specified Showtimes object, in Calendar format.
     */
    public Calendar getDateTime() {
        return dateTime;
    }

    /**
     * Displays the layout of the cinema that is referred to by the specified Showtimes object.
     */
    public void printSeats() {
        int rownum = seatPlan.length;
        int colnum = seatPlan[0].length;
        System.out.println("---------------- <THE SCREEN>-----------------");
        System.out.println();
        System.out.print("columns  ");
        for (int i = 0; i < colnum; i++) {
            System.out.print(i + 1 + "     ");
        }
        System.out.println();
        for (int row = 0; row < rownum; row++) {
            System.out.print("row " + (row + 1) + " ");
            for (int col = 0; col < colnum; col++) {
                if (checkSeatTaken(row, col)) {
                    System.out.print("  XX  ");
                } else {
                    System.out.print("  --  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Returns a boolean value, which depends on the status of a seat.
     *
     * @param RC an int array containing positional information, of a selected seat
     * @return A boolean value, corresponding to whether or not a selected seat is chosen
     */
    public boolean checkSeatTaken(int[] RC) {
        return seatPlan[RC[0] - 1][RC[1] - 1].getStatus();
    }

    /**
     * Returns a boolean value, which depends on the status of a seat.
     *
     * @param row an int containing positional information, row number, of a selected seat
     * @param col an int containing positional information, column number, of a selected seat
     * @return A boolean value, corresponding to whether or not a selected seat is chosen
     */
    public boolean checkSeatTaken(int row, int col) {
        return seatPlan[row][col].getStatus();
    }

    /**
     * Returns the number of available seats there are, for display purposes.
     *
     * @return A int, which counts the number of available seats.
     */
    public int getEmptySeats() {
        int num = 0;
        int rownum = seatPlan.length;
        int colnum = seatPlan[0].length;
        for (int row = 0; row < rownum; row++) {
            for (int col = 0; col < colnum; col++) {
                if (!checkSeatTaken(row, col)) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * Returns the number of available seats there are, for display purposes.
     *
     * @param row    an int containing positional information, row number, of a selected seat
     * @param col    an int containing positional information, column number, of a selected seat
     * @param status a boolean value, which is used to mark the seat's taken status accordingly
     */
    public void setSeatStatus(int row, int col, boolean status) {
        seatPlan[row][col].setStatus(status);
    }

    /**
     * Returns a seat object, for use in operations.
     *
     * @param row an int containing positional information, row number, of a selected seat
     * @param col an int containing positional information, column number, of a selected seat
     * @return a Seat object, corresponding to the seat at the selected position
     */
    public Seat getSeat(int row, int col) {
        return seatPlan[row][col];
    }

    /**
     * Returns the id of the cinema attached to this Showtimes object
     *
     * @return an int, corresponding to the id of the cinema attached to this Showtimes object
     */
    public int getCinemaID() {
        return cinemaID;
    }

    /**
     * Returns the id of the cineplex attached to this Showtimes object
     *
     * @return an int, corresponding to the id of the cineplex attached to this Showtimes object
     */
    public int getCineplexID() {
        return cineplexID;
    }

    /**
     * Returns the number of rows in the cinema attached to this Showtimes object
     *
     * @return an int, which is the number of rows
     */
    public int getMaxRow() {
        return seatPlan.length;
    }

    /**
     * Returns the number of columns in the cinema attached to this Showtimes object
     *
     * @return an int, which is the number of columns
     */
    public int getMaxColumn() {
        return seatPlan[0].length;
    }

}