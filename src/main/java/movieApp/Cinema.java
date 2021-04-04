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

    public String getCinemaCode() {
        return cinemaCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public int getCineplexID() {
        return cineplexID;
    }

    public Seat[][] getSeats() {
        return this.seats;
    }

    public int getR() {
        return rowNum;
    }

    public int getC() {
        return colNum;
    }
}