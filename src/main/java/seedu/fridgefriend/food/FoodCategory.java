package seedu.fridgefriend.food;

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
    FROZEN_ONLY,    // e.g. frozen dumpling, ice cream
    OTHER;

    public static boolean contains(String string) {
        for (FoodCategory foodCategory : values()) {
            if (foodCategory.name().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static FoodCategory convertStringToFoodCategory(String category) {
        if (FoodCategory.contains(category)) {
            return FoodCategory.valueOf(category);
        } else {
            return FoodCategory.OTHER;
        }
    }
}




