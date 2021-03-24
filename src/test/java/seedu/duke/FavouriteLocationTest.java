package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavouriteLocationTest {

    @Test
    void addFavouriteLocation_addOneLocation_oneLocationInFavourites() {
        FavouriteLocation favouriteLocation = new FavouriteLocation();
        seedu.duke.Map nusMap = new seedu.duke.Map();
        favouriteLocation.addFavouriteLocation("E2", nusMap);
        assertEquals(favouriteLocation.getFavouriteLocations().size(), 1);
    }

    @Test
    void addFavouriteLocation_addInvalidLocation() {
        FavouriteLocation favouriteLocation = new FavouriteLocation();
        seedu.duke.Map nusMap = new seedu.duke.Map();
        favouriteLocation.addFavouriteLocation("E100", nusMap);
        assertEquals(favouriteLocation.getFavouriteLocations().size(), 0);
    }
}