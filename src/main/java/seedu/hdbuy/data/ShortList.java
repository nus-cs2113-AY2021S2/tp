package seedu.hdbuy.data;

import java.util.HashMap;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.storage.StorageManager;

public class ShortList {

    private static HashMap<Integer, Unit> units;

    public static HashMap<Integer, Unit> getShortListedUnits() {
        if (units == null) {
            units = new HashMap<>();
            StorageManager.read();
        }
        return units;
    }

    public static void addToShortList(Unit unit) {
        units.put(unit.getId(), unit);
    }
}
