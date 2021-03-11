package seedu.fridgefriend.food;

/**
 * Assume the fridge has these storage locations
 * Reference: https://styledegree.sg/the-right-way-to-store-organize-food-in-fridge/
 */
public enum FoodStorageLocation {
    FREEZER,
    UPPER_SHELF,
    MIDDLE_SHELF,
    LOWER_SHELF,
    DRAWERS,
    FRIDGE_DOOR,
    OTHER;

    public static boolean contains(String string) {
        for (FoodStorageLocation location : values()) {
            if (location.name().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static FoodStorageLocation convertStringToLocation(String rawLocationStr) {
        String processedLocationStr = rawLocationStr.toUpperCase();
        if (FoodStorageLocation.contains(processedLocationStr)) {
            return FoodStorageLocation.valueOf(processedLocationStr);
        } else {
            return FoodStorageLocation.OTHER;
        }
    }
}
