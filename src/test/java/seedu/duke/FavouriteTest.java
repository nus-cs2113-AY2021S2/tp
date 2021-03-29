package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Favourite;
import seedu.duke.data.NusMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FavouriteTest {

    @Test
    void addFavouriteLocation_addOneLocation_oneLocationInFavourites() {
        Favourite favourite = new Favourite();
        NusMap nusMap = new NusMap();
        favourite.addFavouriteLocation("E2", nusMap);
        assertEquals(favourite.getFavourites().size(), 1);
    }

    @Test
    void addFavouriteLocation_addInvalidLocation() {
        Favourite favourite = new Favourite();
        NusMap nusMap = new NusMap();
        favourite.addFavouriteLocation("E100", nusMap);
        assertEquals(favourite.getFavourites().size(), 0);
    }
}