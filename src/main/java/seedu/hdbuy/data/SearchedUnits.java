package seedu.hdbuy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import seedu.hdbuy.common.Unit;

public class SearchedUnits {

    private static ArrayList<Unit> units;

    public static void addToResult(Unit unit) {
        if (units == null) {
            units = new ArrayList<>();
        }
        units.add(unit);
    }

    public static Unit getUnit(int index) {
        if (units == null) {
            Logger.getLogger("SearchedUnits").severe("No search results");
            return null;
        }
        try {
            return units.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            Logger.getLogger("SearchedUnits").severe("Invalid index");
            return null;
        }
    }
}
