package movieApp;

import java.io.Serializable;

public class Cinema implements Serializable {
    private int cineplexID;
    private int capacity;
    private String cinemaCode;
    private int cinemaID;
    private int rowNum;
    private int colNum;
    private Seat[][] seats;

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