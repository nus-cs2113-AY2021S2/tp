package seedu.duke.ui;

import seedu.duke.Block;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.History;
import seedu.duke.Map;
import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidRepeatEntryException;
import seedu.duke.exception.RepeatEntryOutOfBoundException;

import java.util.ArrayList;
import java.util.HashMap;

public class UiManager extends Ui {
    MessagesUi messagesUi = new MessagesUi();
    HistoryUi historyUi = new HistoryUi();
    RouterUi routerUi = new RouterUi();
    EateryUi eateryUi = new EateryUi();
    DailyRouteUi dailyRouteUi = new DailyRouteUi();
    AliasUi aliasUi = new AliasUi();
    FavouriteLocationsUi favouriteLocationsUi = new FavouriteLocationsUi();

    public UiManager() {
        super();
    }

    // Messages
    public void showLogo() {
        messagesUi.showLogo();
    }

    public void showGreetMessage() {
        messagesUi.showGreetMessage();
    }

    public void showByeMessage() {
        messagesUi.showByeMessage();
    }

    public void showHelpMessage() {
        messagesUi.showHelpMessage();
    }

    // History
    public void showHistory(History history) {
        historyUi.showHistory(history);
    }

    public void showClearHistoryResponse() {
        historyUi.showClearHistoryResponse();
    }

    public int getRepeatEntry() throws RepeatEntryOutOfBoundException, InvalidRepeatEntryException {
        return historyUi.getRepeatEntry();
    }

    // Router
    public String[] getRoutingInfo() {
        return routerUi.getRoutingInfo();
    }

    // Eatery
    public int getEateryEntry(Block[] eateries) {
        return eateryUi.getEateryEntry(eateries);
    }

    // Daily Route
    public ArrayList<String> getSchedule() throws InvalidBlockException {
        return dailyRouteUi.getSchedule();
    }

    // Alias
    public HashMap<String, String> getAliasInfo(HashMap<String, String> aliasMap)
            throws InvalidAliasException, InvalidBlockException {
        return aliasUi.getAliasInfo(aliasMap);
    }

    public void showCustomAliases(HashMap<String, String> aliasMap) {
        aliasUi.showCustomAliases(aliasMap);
    }

    public String getDeleteAliasInfo(BlockAlias blockAlias) throws InvalidAliasException {
        return aliasUi.getDeleteAliasInfo(blockAlias);
    }

    public void showFavouriteLocations(FavouriteLocation favouriteLocation) {
        assert favouriteLocation != null : "favouriteLocation must be initialised";
        favouriteLocationsUi.showFavouriteLocations(favouriteLocation);
    }

    public void addFavoriteLocations(FavouriteLocation favouriteLocation, String location, Map nusMap) {
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
}
