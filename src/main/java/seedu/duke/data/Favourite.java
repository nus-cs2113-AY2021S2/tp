package seedu.duke.data;

import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

public class Favourite {

    public ArrayList<String[]> favourites;

    public Favourite() {
        this.favourites = new ArrayList<>();
    }

    public boolean isEmpty() {
        return favourites.isEmpty();
    }

    public int getFavouriteSize() {
        return favourites.size();
    }

    public void addFavourite(String start, String destination) {
        favourites.add(new String[]{start, destination});
    }

    public String[] getSpecificEntry(int index) throws InvalidIndexException {
        try {
            return favourites.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    public void deleteFavourite(int index) throws InvalidIndexException {
        try {
            favourites.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }
}
