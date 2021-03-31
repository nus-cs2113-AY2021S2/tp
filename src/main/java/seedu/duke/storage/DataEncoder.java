package seedu.duke.storage;

import seedu.duke.data.Block;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;
import java.util.Map;

public class DataEncoder {

    public ArrayList<String> encodeHistory(History history) throws InvalidIndexException {
        ArrayList<String> encodedData = new ArrayList<>();
        for (int i = 0; i < history.getHistorySize(); i++) {
            String[] data = history.getSpecificEntry(i);
            encodedData.add(data[0] + "/" + data[1]);
        }
        return encodedData;
    }

    public ArrayList<String> encodeAlias(BlockAlias alias) {
        ArrayList<String> encodedData = new ArrayList<>();
        for (Map.Entry<String, String> aliasPair: alias.getAliasHashMap().entrySet()) {
            encodedData.add(aliasPair.getKey() + "/" + aliasPair.getValue());
        }
        return encodedData;
    }

    public ArrayList<String> encodeNotes(NusMap nusMap) {
        ArrayList<String> encodedData = new ArrayList<>();
        for (Block block : nusMap.getValues()) {
            for (int i = 0; i < block.getNotes().size(); i++) {
                encodedData.add(block.getName() + "/" + block.getNotes().get(i));
            }
        }
        return encodedData;
    }

    public ArrayList<String> encodeDailyRoute(DailyRoute dailyRoute) {
        ArrayList<String> encodedData = new ArrayList<>();
        for (String day : dailyRoute.getSelectableDays()) {
            StringBuilder schedule = new StringBuilder(day + "/");
            for (String block : dailyRoute.getDailyRoute(day)) {
                schedule.append(block + "/");
            }
            encodedData.add(schedule.toString());
        }
        return encodedData;
    }

    public ArrayList<String> encodeFavourite(Favourite favourite) throws InvalidIndexException {
        ArrayList<String> encodedData = new ArrayList<>();
        for (int i = 0; i < favourite.getFavouriteSize(); i++) {
            String[] data = favourite.getSpecificEntry(i);
            encodedData.add(data[0] + "/" + data[1]);
        }
        return encodedData;
    }
}
