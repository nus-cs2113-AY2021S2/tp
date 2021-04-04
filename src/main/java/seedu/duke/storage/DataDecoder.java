package seedu.duke.storage;

import seedu.duke.data.DailyRoute;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.LoadDataException;

import java.util.ArrayList;

public interface DataDecoder {

    default String[] decodeHistoryAndFavouriteData(String encodedData, NusMap nusMap) throws LoadDataException {
        try {
            String[] decodedData = encodedData.split("/");
            checkIfValidLength(decodedData);
            for (int i = 0; i < decodedData.length; i++) {
                nusMap.checkIfValidBlock(decodedData[i]);
            }
            return decodedData;
        } catch (InvalidBlockException e) {
            throw new LoadDataException();
        }
    }

    default String[] decodeAliasAndNoteData(String encodedData, NusMap nusMap) throws LoadDataException {
        try {
            String[] decodedData = encodedData.split("/");
            checkIfValidLength(decodedData);
            nusMap.checkIfValidBlock(decodedData[0]);
            return decodedData;
        } catch (InvalidBlockException e) {
            throw new LoadDataException();
        }
    }

    default String[] decodeDailyRouteData(String encodedData, NusMap nusMap, DailyRoute dailyRoute)
            throws LoadDataException {
        try {
            String[] decodedData = encodedData.split("/");
            if (!isValidDay(decodedData[0], dailyRoute)) {
                throw new LoadDataException();
            }
            for (int i = 1; i < decodedData.length; i++) {
                nusMap.checkIfValidBlock(decodedData[i]);
            }
            return decodedData;
        } catch (InvalidBlockException e) {
            throw new LoadDataException();
        }
    }

    default void checkIfValidLength(String[] decodedData) throws InvalidBlockException {
        if (decodedData.length != 2) {
            throw new InvalidBlockException();
        }
    }

    default boolean isValidDay(String day, DailyRoute dailyRoute) {
        boolean isValidDay = false;
        ArrayList<String> days = dailyRoute.getValidDays();
        for (int i = 0; i < days.size(); i++) {
            isValidDay = day.equals(days.get(i));
            if (isValidDay) {
                break;
            }
        }
        return isValidDay;
    }
}
