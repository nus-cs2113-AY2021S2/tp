package seedu.fridgefriend.food;

//@@author Vinci-Hu

import seedu.fridgefriend.exception.InvalidFoodCategoryException;

/**
 * Subject to changes with discussion.
 */
public enum FoodCategory {
    VEGETABLE,      // e.g. eggplant, spinach, bok choy, including beans and fungus
    FRUIT,          // e.g. strawberry, apple, grapes
    MEAT,           // e.g. pork, beef, lamb, chicken
    SEAFOOD,        // e.g. salmon, mackerel, crab, prawn
    EGG,            // e.g. egg, duck egg, quail egg
    DAIRY,          // e.g. milk, butter, cheese, yoghurt
    BEVERAGE,       // e.g. coke, orange juice
    COOKED_DISH,    // e.g. tomato scrambled eggs, chicken soup
    READY_TO_EAT,   // e.g. sandwich
    FROZEN,    // e.g. frozen dumpling, ice cream
    OTHER;

    //@@author SimJJ96
    public static boolean contains(String string) {
        for (FoodCategory foodCategory : values()) {
            if (foodCategory.name().equals(string)) {
                return true;
            }
        }
        return false;
    }

    //@author
    public static FoodCategory convertStringToFoodCategory(String rawCategoryStr)
            throws InvalidFoodCategoryException {
        String processedCategoryStr = rawCategoryStr.toUpperCase();
        if (FoodCategory.contains(processedCategoryStr)) {
            return FoodCategory.valueOf(processedCategoryStr);
        } else {
            throw new InvalidFoodCategoryException(rawCategoryStr);
        }
    }

    //@@author kwokyto
    public static boolean isValidCategory(String line) {
        return FoodCategory.contains(line.toUpperCase());
    }
    
}




