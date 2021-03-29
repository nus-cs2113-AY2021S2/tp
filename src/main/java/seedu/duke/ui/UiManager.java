package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UiManager {
    private final Scanner in;
    private final PrintStream out;

    public UiManager() {
        this(System.in, System.out);
    }

    public UiManager(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserCommandInput() {
        out.print(CommonMessage.COMMAND_INPUT_HEADER);
        String userInput = in.nextLine();
        out.println(CommonMessage.DIVIDER);
        return userInput;
    }

    public String getUserInput() {
        out.print(CommonMessage.INFO_INPUT_HEADER);
        return in.nextLine().trim();
    }


    public void showMessage(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    public void showMessageWithDivider(String... message) {
        showMessage(message);
        out.println(CommonMessage.DIVIDER);
    }

    public void showLogo() {
        showMessageWithDivider(CommonMessage.LOGO);
    }

    public void showGreetMessage() {
        showMessageWithDivider(CommonMessage.GREETING_MESSAGE);
    }

    /*

    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        favouriteLocationsUi.showFavouriteLocations(favouriteLocation);
    }

    public void addFavoriteLocations(FavouriteLocation favouriteLocation, String location, NusMap nusMap) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        assert location != null : "location must be provided";
        assert nusMap != null : "nusMap must be initialised";
        favouriteLocationsUi.addFavouriteLocations(favouriteLocation, location, nusMap);
    }

    public static String getListOfLocations() {
        return "E1  E1A  E2  E2A  E3  E3A  E4  E4A  E5"
                + System.lineSeparator()
                + "E6  E7  EA  EW1  EW1A EW2  LT1  LT2  LT5  LT6"
                + System.lineSeparator()
                + "AS1 LT7  LT7A IT  T-LAB"
                + System.lineSeparator()
                + "TECHNO EDGE";
    }

    public void deleteFavouriteLocation(FavouriteLocation favouriteLocation, int index) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        favouriteLocationsUi.deleteFavouriteLocation(favouriteLocation, index);
    }
     */
}
