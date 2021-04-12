package movieApp;

import java.io.Serializable;

public class Cinema implements Serializable {
    private static final long serialVersionUID = 6815178382261501263L;
    private final int cineplexID;
    private final int capacity;
    private final String cinemaCode;
    private final int cinemaID;
    private final int rowNum;
    private final int colNum;
    private final Seat[][] seats;

    /**
     * Class constructor.
     */
    public Cinema(String cinemaCode, int cinemaID, int cineplexID, int capacity, int r, int c) {
        this.cinemaCode = cinemaCode;
        this.rowNum = r;
        this.colNum = c;
        this.cineplexID = cineplexID;
        this.cinemaID = cinemaID;
        this.capacity = capacity;
        this.seats = new Seat[r][c];

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                seats[row][col] = new Seat(row, col, false);
            }
        }
    }

    /**
     * Returns a String, which is the id of the Cinema object that can then be used for operations.
     * @return      a String containing hte name of the specified Cinema object
     */
    public String getCinemaCode() {
        return cinemaCode;
    }

    /**
     * Returns an int, which is the full capacity of the specified Cinema object.
     * @return      an int which contains the full capacity of the specified Cinema object
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns an int, which is the ID of the specified Cinema object.
     * @return      an int which contains the ID of the specified Cinema object
     */
    public int getCinemaID() {
        return cinemaID;
    }

    /**
     * Returns an int, which is the ID of the Cineplex the Cinema object resides in.
     * @return      an int which contains the ID of the Cineplex the Cinema object resides in
     */
    public int getCineplexID() {
        return cineplexID;
    }

    /**
     * Returns an array of Seat objects that correspond to the Cinema's available seats
     * @return      an array of Seat objects that correspond to the Cinema's available seats
     */
    public Seat[][] getSeats() {
        return this.seats;
    }

    /**
     * Returns the number of rows of seats in the cinema
     * @return      an int containing the number of rows of seats in the cinema
     */
    public int getR() {
        return rowNum;
    }

    /**
     * Returns the number of columns of seats in the cinema
     * @return      an int containing the number of columns of seats in the cinema
     */
    public int getC() {
        return colNum;
    }
}