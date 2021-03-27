package seedu.duke.ui;

import seedu.duke.FavouriteLocation;

public class FavouriteLocationsUi extends Ui {

    public FavouriteLocationsUi() {
    }


    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        if (favouriteLocation.getFavouriteLocations().size() == 0) {
            System.out.println("There are no favourite locations.");
        } else {
            for (int i = 0; i != favouriteLocation.getFavouriteLocations().size(); i += 1) {
                System.out.println((i + 1) + ". " + favouriteLocation.getFavouriteLocations().get(i));
            }
        }
    }
}
